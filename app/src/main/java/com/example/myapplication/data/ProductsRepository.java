package com.example.myapplication.data;

import com.example.myapplication.data.bean.Product;
import com.example.myapplication.data.network.ProductsNetwork;

import java.util.ArrayList;

public class ProductsRepository {
    private ProductsNetwork network;

    public ProductsRepository(ProductsNetwork network) {
        this.network = network;
    }

    public ArrayList<Product> getProductsDetails() {
        return network.fetchDetails();
    }
}
