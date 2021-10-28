package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(_items: Array<Book>, _ocl: View.OnClickListener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val items = _items
    val ocl  = _ocl

    class ViewHolder(_view: View, ocl: View.OnClickListener): RecyclerView.ViewHolder(_view) {
        val view = _view.apply { setOnClickListener(ocl) }
        val title: TextView = _view.findViewById(R.id.titleView)
        val author: TextView = _view.findViewById(R.id.authorView)

        fun bind(item: Book){
            title.text = item.title
            author.text = item.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false), ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = items[position]
        holder.bind(i)
        holder.view.setOnClickListener { ocl }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}