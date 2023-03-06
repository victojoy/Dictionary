package com.example.dictionary

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.dictionary.databinding.FragmentVideoBinding

class VideoFragment : Fragment(R.layout.fragment_video) {

    private lateinit var binding: FragmentVideoBinding

    private val webViewClient: WebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url = request?.url.toString()

            return if (url.startsWith(getString(R.string.video_zone_url))) {
                binding.progressBar.visibility = View.VISIBLE
                false
            } else {
                true
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() {
        with(binding) {
            webView.loadUrl(getString(R.string.video_zone_url))
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = webViewClient
        }
    }
}