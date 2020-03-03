package com.example.myapplication.service


import com.example.myapplication.model.Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//BASE URL API
private const val BASE_URL =  "https://android-kotlin-fun-mars-server.appspot.com"

//INSTANCE RETROFIT
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//INTERFACE API
interface InterfaceService{

    @GET("realestate")
    fun getJokes():Call<List<Item>>
}

//PUBLIC API OBJECT
object ServiceApi{

    val retrofitService:InterfaceService by lazy {
        retrofit.create(InterfaceService::class.java)
    }
}