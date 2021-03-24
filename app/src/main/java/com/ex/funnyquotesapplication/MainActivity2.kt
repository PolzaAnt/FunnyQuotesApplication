package com.ex.funnyquotesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.funnyactivity.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.funnyactivity)
        button_return.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }

        smile.setOnClickListener {
           val newIntent1=Intent(this, MainActivity3::class.java)
            startActivity(newIntent1)
        }
    }
}