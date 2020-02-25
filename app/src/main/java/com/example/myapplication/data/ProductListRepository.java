package com.example.myapplication.data;

import com.example.myapplication.data.bean.ItemInfo;
import com.example.myapplication.data.network.ProductListNetwork;

import java.util.List;

public class ProductListRepository {
    private ProductListNetwork network;

    public ProductListRepository(ProductListNetwork network) {
        this.network = network;
    }

    public List<ItemInfo> getProductsList(String category) {
        return network.fetchProList(category);
    }
}
