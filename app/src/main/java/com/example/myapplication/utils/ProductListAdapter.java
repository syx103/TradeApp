package com.example.myapplication.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.bean.ItemInfo;
import com.example.myapplication.databinding.ProlistItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter {

    private List<ItemInfo> itemInfoList;
    private Context context;

    public ProductListAdapter(List<ItemInfo> itemInfoList, Context context) {
        if (itemInfoList == null) {
            itemInfoList = new ArrayList<>();
        }
        this.itemInfoList = itemInfoList;
        this.context = context;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //下面这个Binding类名根据对应的xml文件生成，如xml文件名为prolist_item，则对应的Binding类名为ProlistItemBinding
        ProlistItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.prolist_item, parent, false);
        return new MyViewHolder(binding.getRoot());     //getRoot方法返回和对应binding绑定的布局文件中最外层的view
    }

    //此方法还是对数据进行赋值，但是是通过xml对应的binding对象
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProlistItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
        assert binding != null;
        binding.setListitem(itemInfoList.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemInfoList.size();
    }
}
