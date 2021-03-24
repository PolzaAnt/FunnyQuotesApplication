package com.ex.funnyquotesapplication


import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex.funnyquotesapplication.data.entity.Quotes
import kotlinx.android.synthetic.main.activity_main2.view.*

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {
    private var listQuotes = ArrayList<Quotes>()
    fun updateList(list: List<Quotes>?) {
        listQuotes = list as ArrayList<Quotes>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listQuotes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listQuotes[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(quotes: Quotes) {
            with(itemView) {
                text.text = Html.fromHtml(quotes.html_text)

            }
        }
    }
}


