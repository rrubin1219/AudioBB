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

    private lateinit var list : ArrayList<Book>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            list = it.getParcelableArrayList<Book>(BOOK_KEY) as ArrayList<Book>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)

        val itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)

        val onClickListener = View.OnClickListener {
            val position = recyclerView.getChildAdapterPosition(it)
            itemViewModel.setItem(list[position])
        }
        recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = BookAdapter(list, onClickListener)
        }

        return layout
    }

    companion object {
        fun newInstance(list: ArrayList<Book>) = BookListFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(BOOK_KEY, list)
            }
        }
    }

    interface SwitchEvent{
        fun selectionMode()
    }
}