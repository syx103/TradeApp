package com.example.myapplication.data.bean;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemInfo extends BaseObservable {

    @SerializedName("productId")
    private int id;
    private String title;
    private String content;
    @SerializedName("createTime")
    private String time;
    private String location;
    @SerializedName("images")
    private List<String> imageUrl;
    private int price;

    public ItemInfo getItemInfo() {
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
