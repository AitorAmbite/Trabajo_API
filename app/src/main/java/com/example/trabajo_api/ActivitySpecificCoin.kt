package com.example.trabajo_api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajo_api.databinding.ActivitySpecificCoinBinding

class ActivitySpecificCoin : AppCompatActivity(){
    lateinit var binding : ActivitySpecificCoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpecificCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object{
        private const val ID_COIN = "ID_COIN"

        fun createSpecificCoinActivity(contexto: Context, id:String){
            val intent = Intent(contexto,ActivitySpecificCoin::class.java)
            intent.putExtra(ID_COIN,id)
            contexto.startActivity(intent)
        }
    }
}