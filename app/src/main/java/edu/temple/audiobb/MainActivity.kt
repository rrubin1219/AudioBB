package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), BookListFragment.SwitchEvent {
    private var twoPane = false
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        twoPane = findViewById<View>(R.id.displayContainer) != null
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        //Pop display frag from stack if book was preivously selected, but user had since cleared selection
        if (supportFragmentManager.findFragmentById(R.id.displayContainer) is BookDisplayFragment && itemViewModel.getItem().value == null){
            supportFragmentManager.popBackStack()
        }

        //Remove display fragment if moving from single-pane to double pane and book has been selected
        if (supportFragmentManager.findFragmentById(R.id.listContainer) is BookDisplayFragment && twoPane) {
            supportFragmentManager.popBackStack()
        }
        //If fragment not previously loaded (first time loading)
        if (savedInstanceState == null) {
            getBooks()?.let { BookListFragment.newInstance(it) }?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.listContainer, it)
                    .commit()
            }
        }

        //If second container id available
        if(twoPane){
            //Add display if available
            if (supportFragmentManager.findFragmentById(R.id.displayContainer) == null){
                supportFragmentManager.beginTransaction()
                    .add(R.id.displayContainer, BookDisplayFragment())
                    .commit()
            }
            //If moving to single-pane but book was selected before switch
            else if (itemViewModel.getItem().value != null){
                supportFragmentManager.beginTransaction()
                    .add(R.id.displayContainer, BookDisplayFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun getBooks(): ArrayList<Book>? {
        val books: ArrayList<Book>? = null
        val titles = resources.getStringArray(R.array.titles)
        val authors = resources.getStringArray(R.array.authors)
        if (books != null) {
            books.add(Book(titles[0], authors[0]))
            books.add(Book(titles[1], authors[1]))
            books.add(Book(titles[2], authors[2]))
            books.add(Book(titles[3], authors[3]))
            books.add(Book(titles[4], authors[4]))
            books.add(Book(titles[5], authors[5]))
            books.add(Book(titles[6], authors[6]))
            books.add(Book(titles[7], authors[7]))
            books.add(Book(titles[8], authors[8]))
            books.add(Book(titles[9], authors[9]))
        }
        return books

    }


    override fun selctionMode() {
        if(!twoPane){
            supportFragmentManager.beginTransaction()
                .add(R.id.displayContainer, BookDisplayFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}