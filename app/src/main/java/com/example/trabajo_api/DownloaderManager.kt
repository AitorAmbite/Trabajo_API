package com.example.trabajo_api

import com.example.trabajo_api.coinRelated.CoinBasic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

class
DownloaderManager {
    companion object{
        suspend fun downloadAllCoins(): String? {
            val client = OkHttpClient()
            val url = "https://api.coinpaprika.com/v1/coins"
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            return call.execute().body?.string()
        }

        suspend fun downloadSpecificCoin(coinId: String):String?{
            val client = OkHttpClient()
            val url = "https://api.coinpaprika.com/v1/coins/$coinId"
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            return call.execute().body?.string()
        }


        suspend fun transformJsonToGson(jsonData :String): List<CoinBasic>? {
            val JsonObject = JSONArray(jsonData)
            println(JsonObject)
            val gson = Gson()
            val itemType = object : TypeToken<List<CoinBasic>>(){}.type
            return gson.fromJson<List<CoinBasic>>(jsonData.toString(), itemType)
        }
    }
}