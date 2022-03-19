package com.example.animeapp.ui.fragment


import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.data.base.BaseFragment
import com.example.animeapp.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetailFragment : BaseFragment<FragmentDetailBinding>(
    R.layout.fragment_detail
) {


    override val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    private val animeViewModel: AnimeViewModel by activityViewModels()

    override fun setupViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            animeViewModel.description.observe(viewLifecycleOwner) { description ->
                binding.titleTv.text = description.toString()

            }
        }
    }
}