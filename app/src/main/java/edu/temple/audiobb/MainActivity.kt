package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //val titles = resources.getStringArray(R.array.titles)
    //val authors = resources.getStringArray(R.array.authors)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*   val arr: BookList? = null
   if (arr != null) {
       arr.add(Book(titles[0], authors[0]))
       arr.add(Book(titles[1], authors[1]))
       arr.add(Book(titles[2], authors[2]))
       arr.add(Book(titles[3], authors[3]))
       arr.add(Book(titles[4], authors[4]))
       arr.add(Book(titles[5], authors[5]))
       arr.add(Book(titles[6], authors[6]))
       arr.add(Book(titles[7], authors[7]))
       arr.add(Book(titles[8], authors[8]))
       arr.add(Book(titles[9], authors[9]))
   }
supportFragmentManager.beginTransaction()
       .add(R.id.lisontainer, BookListFragment.newInstance(getBook()))
       .add(R.id.displayContainer, BookDisplayFragment())
       .commit()*/

}
}