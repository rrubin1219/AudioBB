package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*supportFragmentManager.beginTransaction()
            .add(R.id.listContainer, BookListFragment.newInstance(getBook()))
            .add(R.id.displayContainer, BookDisplayFragment())
            .commit()*/
    }

    private fun getBook(): Array<Book>{
        val titles = resources.getStringArray(R.array.titles)
        val authors = resources.getStringArray(R.array.authors)

        return arrayOf()
    }
}