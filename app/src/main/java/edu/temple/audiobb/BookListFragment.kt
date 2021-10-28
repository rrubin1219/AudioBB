package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//List Fragment for the Book Object
private const val BOOK_KEY = "books"

class BookListFragment : Fragment() {

    private lateinit var list : Array<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            list = it.getParcelableArray(BOOK_KEY) as Array<Book>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)

        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        val onClickListener = View.OnClickListener {
            val position = recyclerView.getChildAdapterPosition(it)
            itemViewModel.setItem(list[position])
        }

        //recyclerView.adapter = BookAdapter(list, onClickListener)

        return layout
    }

    companion object {
        fun newInstance(list: Array<Book>) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                   putParcelableArray(BOOK_KEY, list)
                }
            }
    }
}