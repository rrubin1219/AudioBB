package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

//Display Fragment for the Book Object
class BookDisplayFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_display, container, false)

        val titleView = layout.findViewById<TextView>(R.id.titleView)
        val authorView = layout.findViewById<TextView>(R.id.authorView)

        ViewModelProvider(requireActivity())
            .get(ItemViewModel::class.java)
            .getItem()
            .observe(requireActivity(), {
                titleView.text = it.title
                authorView.text = it.author
            })
        return layout
    }

}