package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(_items: ArrayList<Book>): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val items = _items
    //private val ocl  = _ocl

    class ViewHolder(_view: View): RecyclerView.ViewHolder(_view) {
        private val title: TextView = _view.findViewById(R.id.titleText)
        private val author: TextView = _view.findViewById(R.id.authorText)
        //val view = _view.apply { setOnClickListener(ocl) }

        fun bind(book: Book){
            title.text = book.title
            author.text = book.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder.view.setOnClickListener(ocl)
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}