package com.example.audiophile.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.audiophile.R
import com.example.audiophile.databinding.FragmentSplashscreenBinding

class SplashFragment: Fragment(R.layout.fragment_splashscreen){
    companion object{
        fun newInstance() = SplashFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSplashscreenBinding.bind(view)
    }
}
