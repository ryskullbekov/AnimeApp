package com.example.animeapp.data.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.example.animeapp.R

abstract class BaseFragment<Binding : ViewBinding>(@LayoutRes layoutId: Int) : Fragment(
    layoutId
) {
    protected abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupViews()
    }


    open fun initListeners() {

    }


    open fun setupViews() {

    }


}