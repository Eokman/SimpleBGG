package com.eokman.simplebgg.presentation.util

import androidx.lifecycle.LiveData

class ListLiveData<T>: LiveData<List<T>>() {
    private val items = mutableListOf<T>()

    init {
        value = items
    }

    fun add (item: T) {
        this.items.add(item)
        value = items
    }

    fun addAll (items: List<T>) {
        this.items.addAll(items)
        value = items
    }

    fun remove (item: T) {
        this.items.remove(item)
        value = items
    }

    fun clear () {
        this.items.clear()
        value = items
    }

    fun get (index: Int) = items[index]

    fun size(): Int = items.size
}