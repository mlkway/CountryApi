package com.raywenderlich.firstapichallenge.ui.countryscreen

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.firstapichallenge.data.Country
import com.raywenderlich.firstapichallenge.data.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CountriesScreenViewModel : ViewModel() {

    private var _countryModel = MutableLiveData<List<Country>>()

    val countryModel: LiveData<List<Country>> get() = _countryModel

    private var _loading = MutableLiveData<Boolean>()

    val loading: LiveData<Boolean> get() = _loading



     fun load(){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                _loading.postValue(true)
                val data = Network.apiService.getAllData()
                if (data.isSuccessful){
                    _loading.postValue(false)
                }else{
                    _loading.postValue(true)
                }

                CoroutineScope(Dispatchers.Main).launch {
                    _countryModel.postValue(data.body())
                }

            }catch (e: Exception){
                throw e
            }
        }

    }





}