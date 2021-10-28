package edu.temple.audiobb

class BookList{
    private val list = ArrayList<Book>()

    fun add(book: Book) {
        list.add(book)
    }
    fun remove(book: Book){
        list.remove(book)
    }
    fun get(pos:Int): Book{
        return list[pos]
    }
    fun size(pos: Int){
        list.size
    }
}