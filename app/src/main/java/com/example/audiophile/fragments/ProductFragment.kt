package com.example.audiophile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.audiophile.R
import com.example.audiophile.databinding.FragmentProductBinding

class ProductFragment : Fragment(R.layout.fragment_product) {
    companion object{
        private const val KEY_MODEL = "MODEL"
        private const val KEY_DESC = "DESC"
        private const val KEY_IMAGE = "IMAGE"
        fun newInstance() = ProductFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProductBinding.bind(view)

        binding.imageProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
        binding.imageClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(HeadphonesFragment.newInstance())
        }
        binding.reviews.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ReviewsFragment.newInstance())
        }
        binding.shops.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ShopsFragment.newInstance())
        }
    }
}