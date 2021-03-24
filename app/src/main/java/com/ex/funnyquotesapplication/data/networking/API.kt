package com.ex.funnyquotesapplication.data.networking


import com.ex.funnyquotesapplication.data.dto.QuotesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("random")
    fun getQuotes(
        @Query("num") num:Int
    ):Deferred<Response<List<QuotesResponse>>>


}

//http://umorili.herokuapp.com/api/get?site=bash.im&name=bash&num=100