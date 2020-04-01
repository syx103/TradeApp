package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.bean.ItemInfo
import com.example.myapplication.databinding.ProlistItemBinding

class CommonAdapter(private val resId: Int, private val list: List<ItemInfo>) :
        RecyclerView.Adapter<CommonAdapter.MyViewHolder>() {

    class MyViewHolder(viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
        var binding: ProlistItemBinding = viewDataBinding as ProlistItemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ProlistItemBinding>(LayoutInflater.from(parent.context),
                resId, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.binding.listitem = item

//        Log.d("ttw", "${item.title}  ${item.price}  ${item.time}  ${item.imageUrl}")
        holder.itemView.setOnClickListener {
            onListItemClicked.onItemClick(holder.itemView, position)
        }
    }

    lateinit var onListItemClicked: OnListItemClicked

    interface OnListItemClicked {
        fun onItemClick(view: View, pos: Int)
    }
}