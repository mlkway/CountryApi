package com.raywenderlich.firstapichallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.firstapichallenge.data.Network
import com.raywenderlich.firstapichallenge.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        load()


    }



    private fun load(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = Network.apiService.getAllData()
                Log.d("TAG", data.body().toString())
                CoroutineScope(Dispatchers.Main).launch {

                    adapter = CountryAdapter(data.body())
                    val layoutManager = GridLayoutManager(this@MainActivity,1)
                    binding.recyclerview.layoutManager = layoutManager
                    binding.recyclerview.adapter = adapter


                }

            }catch (e: Exception){
                throw e
            }
        }

    }


}