package com.example.myapplication.data;

import com.example.myapplication.data.bean.ProDetails;
import com.example.myapplication.data.network.ProDetailsNetwork;

public class ProDetailsRepository {
    private ProDetailsNetwork network;

    public ProDetailsRepository(ProDetailsNetwork network) {
        this.network = network;
    }

    public ProDetails getProDetails(String category) {
        return network.fetchProDetails(category);
    }
}
