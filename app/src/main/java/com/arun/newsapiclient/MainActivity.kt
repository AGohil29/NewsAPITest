package com.arun.newsapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arun.newsapiclient.databinding.ActivityMainBinding
import com.arun.newsapiclient.presentation.adapter.NewsAdapter
import com.arun.newsapiclient.presentation.viewmodel.NewsViewModel
import com.arun.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragment.findNavController()
        viewModel = ViewModelProvider(this,factory)
            .get(NewsViewModel::class.java)
    }
}