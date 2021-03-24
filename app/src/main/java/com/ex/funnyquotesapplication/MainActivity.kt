package com.ex.funnyquotesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.funnyquotesapplication.data.dto.QuotesResponse
import com.ex.funnyquotesapplication.data.entity.Quotes
import com.ex.funnyquotesapplication.data.mappers.QuotesMapper
import com.ex.funnyquotesapplication.data.networking.API
import com.ex.funnyquotesapplication.data.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        funnyText.setOnClickListener {
val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val retrofit: API = RetrofitFactory().getRetrofit()
        val quotesAdapter = QuotesAdapter()


        list.apply {
            adapter = quotesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        button_get.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                val response: Response<List<QuotesResponse>> = retrofit.getQuotes(100).await()

                if (response.isSuccessful) {
                    val quotesResponse: List<QuotesResponse>? = response.body()
                    val quotes: List<Quotes>? = quotesResponse?.map {
                        QuotesMapper().map(it)
                    }

                    withContext(Dispatchers.Main) {
                        quotesAdapter.updateList(quotes)
                    }
                }else {
                    Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}




