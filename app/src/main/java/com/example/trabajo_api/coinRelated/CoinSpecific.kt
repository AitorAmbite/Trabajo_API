package com.example.trabajo_api.coinRelated

import com.google.gson.annotations.SerializedName


data class CoinSpecific (
    var id: String,
    var name: String,
    var symbol: String,
    var rank: Int,
    var description: String,
    @SerializedName("open_source")var openSource:Boolean
    )