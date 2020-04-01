package com.example.myapplication.data.bean

import com.google.gson.annotations.SerializedName

class ProItemOuter {
    var status = 0
    var msg = ""
    @SerializedName("result")
    lateinit var itemList: List<ItemInfo>
}