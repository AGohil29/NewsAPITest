package com.arun.newsapiclient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.newsapiclient.databinding.FragmentNewsBinding
import com.arun.newsapiclient.presentation.adapter.NewsAdapter
import com.arun.newsapiclient.presentation.viewmodel.NewsViewModel


class NewsFragment : Fragment() {
    private  lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var fragmentNewsBinding: FragmentNewsBinding
    private var country = "us"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsBinding = FragmentNewsBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        newsAdapter= (activity as MainActivity).newsAdapter
        newsAdapter.setOnItemClickListener {
          val bundle = Bundle().apply {
             putSerializable("selected_article",it)
          }
          findNavController().navigate(
              R.id.action_newsFragment_to_infoFragment,
              bundle
          )
        }
        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {

        viewModel.getNewsHeadLines(country)
        viewModel.newsHeadLines.observe(viewLifecycleOwner,{response->
            when(response){
               is com.arun.newsapiclient.data.util.Resource.Success->{
                     hideProgressBar()
                     response.data?.let {
                         Log.i("MYTAG","came here ${it.articles.toList().size}")
                         newsAdapter.differ.submitList(it.articles.toList())
                     }
               }
                is com.arun.newsapiclient.data.util.Resource.Error->{
                   hideProgressBar()
                   response.message?.let {
                       Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                   }
                }
                is com.arun.newsapiclient.data.util.Resource.Loading->{
                    showProgressBar()
                }
            }
        })
    }

    private fun initRecyclerView() {
       // newsAdapter = NewsAdapter()
        fragmentNewsBinding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

    private fun showProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.INVISIBLE
    }

}
















