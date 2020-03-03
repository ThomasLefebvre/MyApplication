package com.example.chucknorris

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Item
import com.example.myapplication.service.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemViewModel : ViewModel() {

     val listItem=MutableLiveData<List<Item>>()

     val title=MutableLiveData<String>().apply { value= "Bonjour le monde" }




     fun getJokeAPI(){
          ServiceApi.retrofitService.getJokes().enqueue(object :Callback<List<Item>>{
               override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                    Log.d("API FAILURE",t.message!!)
               }

               override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                    listItem.value=response.body()
                    Log.d("VIEWMODEL",listItem.value.toString())
               }

          })
     }
}