package com.arun.newsapiclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.arun.newsapiclient.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWebViewBinding.bind(view)
        val args : WebViewFragmentArgs by navArgs()
        val urlToOpen = args.articleUrl

        binding.wvInfo.apply {
            webViewClient = WebViewClient()
            if (urlToOpen != "") {
                loadUrl(urlToOpen)
            }
        }
    }
}