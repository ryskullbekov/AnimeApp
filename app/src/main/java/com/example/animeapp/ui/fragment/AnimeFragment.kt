package com.example.animeapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.data.base.BaseFragment
import com.example.animeapp.data.model.Info
import com.example.animeapp.databinding.FragmentAnimeBinding
import com.example.animeapp.ui.adapter.AnimeAdapter

class AnimeFragment : BaseFragment<FragmentAnimeBinding>(
    R.layout.fragment_anime

) {
    override val binding: FragmentAnimeBinding by viewBinding(FragmentAnimeBinding::bind)
    private val animeViewModel: AnimeViewModel by activityViewModels()
    private val adapter = AnimeAdapter { AnimeModel -> onClick(AnimeModel) }

    override fun setupViews() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter.setList(animeViewModel.getBooks())
        binding.recyclerview.adapter = adapter
    }

    private fun onClick(model: Info) {
        animeViewModel.putDescription(model.description)
        findNavController().navigate(R.id.booksDetailsFragment)
    }
}