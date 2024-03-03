package com.example.quotify

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context) : ViewModel() {
    
    private var quotesList:Array<Quotes> = emptyArray()
    private var index = 0
    
    
    init {
        quotesList = loadQuotesFromAssests()
    }

    private fun loadQuotesFromAssests(): Array<Quotes> {
        val inputStream = context.assets.open("assests.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Quotes>::class.java)

    }

    fun getQuote() = quotesList[index]

    fun nextQuote() = quotesList[++index]
    fun previousQuote() = quotesList[--index]

}