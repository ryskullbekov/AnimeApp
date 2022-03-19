package com.example.animeapp.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animeapp.data.model.Info
import com.example.animeapp.data.network.NetworkClient

class AnimeViewModel  : ViewModel() {
    val description = MutableLiveData<String>()

    fun getBooks(): List<Info> {
        return NetworkClient().getAnime()
    }

    fun putDescription(text: String) {
        description.value = text
    }
}