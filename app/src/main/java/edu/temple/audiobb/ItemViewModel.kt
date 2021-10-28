package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel: ViewModel() {
    private val itemViewModel: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }
    fun getItem(): LiveData<Book>{
        return itemViewModel
    }
    fun setItem(item: Book){
        itemViewModel.value = item
    }
}