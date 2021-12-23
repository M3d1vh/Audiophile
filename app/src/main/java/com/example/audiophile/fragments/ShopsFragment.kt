package com.example.audiophile.fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.adapter.ShopAdapter
import com.example.audiophile.data.DataSource
import com.example.audiophile.databinding.FragmentShopsBinding

class ShopsFragment : Fragment(R.layout.fragment_shops) {
    companion object{
        fun newInstance() = ShopsFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentShopsBinding.bind(view)

        binding.rvShops.layoutManager = LinearLayoutManager(requireContext())
        binding.rvShops.adapter = ShopAdapter(DataSource.Shops) {}
        binding.imageClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProductFragment.newInstance())
        }
    }
}
