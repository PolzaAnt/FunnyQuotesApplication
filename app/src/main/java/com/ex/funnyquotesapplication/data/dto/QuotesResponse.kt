package com.ex.funnyquotesapplication.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuotesResponse(
    @Json(name = "Site")
    val site: String? = null,
    @Json(name = "Name")
    val name: String? = null,
    @Json(name = "Desc")
    val desc: String? = null,
    @Json(name = "elementPureHtml")
    val html_text: String? = null,
    @Json(name = "Link")
    val link: String? = null
)