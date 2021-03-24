package com.ex.funnyquotesapplication.data.mappers


import com.ex.funnyquotesapplication.data.dto.QuotesResponse
import com.ex.funnyquotesapplication.data.entity.Quotes


class QuotesMapper {
    fun map(from: QuotesResponse): Quotes {

        return Quotes(
            site = from.site.orEmpty(),
            name = from.name.orEmpty(),
            desc = from.desc.orEmpty(),
            html_text = from.html_text.orEmpty(),
            link = from.link.orEmpty()
        )
    }
}