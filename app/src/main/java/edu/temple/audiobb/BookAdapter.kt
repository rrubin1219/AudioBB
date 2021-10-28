package edu.temple.audiobb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(_items: ArrayList<Book>, _ocl: View.OnClickListener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val items = _items
    private val ocl  = _ocl

    class ViewHolder(_view: View, ocl: View.OnClickListener): RecyclerView.ViewHolder(_view) {
        // val title: TextView = _view.findViewById(R.id.titleText)
        //val author: TextView = _view.findViewById(R.id.authorText)

        val view = _view.apply { setOnClickListener(ocl) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false), ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.title.text = items[position].title
        //holder.author.text = items[position].author
        holder.view.setOnClickListener(ocl)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}