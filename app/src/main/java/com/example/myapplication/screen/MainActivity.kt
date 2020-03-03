package com.example.myapplication.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.chucknorris.ItemAdapter
import com.example.chucknorris.ItemViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter:ItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

       val viewModel= ViewModelProviders.of(this).get(ItemViewModel::class.java)

        binding.lifecycleOwner=this

        viewModel.getJokeAPI()

        adapter= ItemAdapter()

        binding.recyclerView.adapter=adapter

        viewModel.listItem.observe(this, Observer {
            adapter.submitList(it)
        })

        Picasso.get().load("https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg").into(binding.imageView2)
    }
}
