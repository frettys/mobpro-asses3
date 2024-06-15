package org.d3if3148.booklist.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3148.booklist.model.Book
import org.d3if3148.booklist.network.BookApi

class MainViewModel: ViewModel() {

    var data = mutableStateOf(emptyList<Book>())
        private set

    init {
        retrieveData()
    }

    private fun retrieveData(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                data.value = BookApi.service.getBook()
            } catch (e: Exception){
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}