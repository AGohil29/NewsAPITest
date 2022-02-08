package com.anushka.newsapiclient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.anushka.newsapiclient.databinding.FragmentInfoBinding
import com.bumptech.glide.Glide

class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        Glide.with(fragmentInfoBinding.ivArticleImage.context)
            .load(article.urlToImage)
            .into(fragmentInfoBinding.ivArticleImage)

        fragmentInfoBinding.tvTitle.text = article.title
        fragmentInfoBinding.tvAuthor.text = article.author
        fragmentInfoBinding.tvDate.text = article.publishedAt
        fragmentInfoBinding.tvContent.text = article.content
        fragmentInfoBinding.wvInfo.apply {
          webViewClient = WebViewClient()
          if(article.url!="") {
              loadUrl(article.url)
          }
        }
    }
}







