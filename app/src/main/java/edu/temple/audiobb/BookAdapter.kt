package edu.temple.audiobb

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(_items: Array<Book>, _ocl: View.OnClickListener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(_view:TextView, ocl: View.OnClickListener): RecyclerView.ViewHolder(_view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}