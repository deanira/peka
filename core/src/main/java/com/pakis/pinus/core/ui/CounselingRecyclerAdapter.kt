package com.pakis.pinus.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pakis.pinus.core.R
import com.pakis.pinus.core.databinding.ItemCounselingBinding
import com.pakis.pinus.core.domain.model.Conselor

class CounselingRecyclerAdapter : RecyclerView.Adapter<CounselingRecyclerAdapter.ListViewHolder>() {

    private var mData = ArrayList<Conselor>()

    fun setData(items: List<Conselor>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_counseling, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCounselingBinding.bind(itemView)
        fun bind(items: Conselor) {
            with(binding) {
                tvName.text = items.name
                tvAddress.text = items.address
                tvLink.text = items.webUrl
                tvTelepon.text = items.phone
            }
        }
    }
}