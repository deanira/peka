package com.pinus.pakis.ui.dashboard.conseling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pinus.pakis.databinding.ItemConselingBinding

class ConsellingRecyclerAdapter : RecyclerView.Adapter<ConsellingRecyclerAdapter.ListViewHolder>() {

    private var mData = ArrayList<Conselling>()

    fun setData(items: List<Conselling>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRecyclerviewBinding =
            ItemConselingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRecyclerviewBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ListViewHolder(private val binding: ItemConselingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Conselling) {
            with(binding) {
                tvName.text = items.name
                tvAddress.text = items.address
                tvLink.text = items.website
                tvTelepon.text = items.phone
            }
        }
    }
}