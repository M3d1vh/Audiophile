package com.example.audiophile.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.data.DataSource.Headphones
import com.example.audiophile.databinding.FragmentHeadphonesBinding


class HeadphonesFragment : Fragment(R.layout.fragment_headphones) {
    companion object{
        fun newInstance() = HeadphonesFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHeadphonesBinding.bind(view)
        binding.rvHeadphones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHeadphones.adapter = HeadphoneAdapter(Headphones) {
            (activity as MainActivity).navigateToFragment(ProductFragment.newInstance())
        }
        binding.imageProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
    }
}