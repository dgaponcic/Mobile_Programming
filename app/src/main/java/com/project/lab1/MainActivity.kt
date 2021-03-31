package com.project.lab1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
//    private lateinit var apiService: APICommunication
    private lateinit var webView: WebView


//    private fun auth() {
////        showProgress()
//        Log.d("lala3", "ss")
//        MainScope().launch {
////            val webView = WebView()
////            webView.setWebViewClient(object : WebViewClient() {
////                override fun onPageFinished(view: WebView, url: String) {
//////                val code: String = url.getQueryParameter("code")
////                    Log.d("url", url)
////                    // ...
////                }
////            })
//            Log.d("lala4", "ss2")
//            kotlin.runCatching {
//                apiService.auth()
//            }.onSuccess {
////                handleAPIData(it)
//                Log.d("jj", it.toString())
//            }.onFailure {
//                Log.d("lala2", it.toString())
//                print(it)
////                MainScope().launch { hideProgress() }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
//        apiService = APICommunication()
//        val webView = WebView(this)
//        webView.webViewClient = WebViewClient()


//        auth()
        binding = ActivityMainBinding.inflate(layoutInflater)

        webView = binding.webView
        webView.settings.setJavaScriptEnabled(true)
        val a = this
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
//                Log.d("hehe", url)
//                view?.loadUrl(url)
                val uri: Uri = Uri.parse(url)
                val token = uri.getQueryParameter("code");
                Log.d("hehe2", token.toString())
                val intent = Intent(a, Menu::class.java)
                intent.putExtra("token", token);
                startActivity(intent)

                return true
            }
        }
        webView.loadUrl("https://unsplash.com/oauth/authorize?client_id=8zPmZv_H6-lGzuPd-AODt41eFcINcaDxa9emLLYQHXo&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&scope=public+read_user")

//        binding.
//        auth()

        setContentView(binding.root)
//        apiService = APICommunication()

//        var posts = intent.getSerializableExtra("posts")
//
//
//        recyclerListExampleButton.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            intent.putExtra("posts", posts);
//            startActivity(intent)
//        }
    }
}

