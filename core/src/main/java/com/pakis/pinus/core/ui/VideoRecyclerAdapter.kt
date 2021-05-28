package com.pakis.pinus.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pakis.pinus.core.R
import com.pakis.pinus.core.databinding.ItemVideoBinding
import com.pakis.pinus.core.domain.model.Video
import com.pakis.pinus.core.ui.webview.WebviewActivity
import com.pakis.pinus.core.utils.Helper.loadImage

class VideoRecyclerAdapter : RecyclerView.Adapter<VideoRecyclerAdapter.ListViewHolder>() {

    var mData = ArrayList<Video>()

    fun setData(items: ArrayList<Video>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemVideoBinding.bind(itemView)
        fun bind(items: Video) {
            binding.ivThumbnail.loadImage(items.thumbnailPath)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.URL, items.link)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}