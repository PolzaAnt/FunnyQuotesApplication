package com.ex.funnyquotesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main3.button_return
import kotlinx.android.synthetic.main.funnyactivity.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val webView:WebView = findViewById(R.id.web_view)
        val webSettings:WebSettings=webView.settings
        webSettings.javaScriptEnabled
        val file ="file:android_asset/myImage.gif"
        webView.loadUrl(file)

        button_return.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
    }
