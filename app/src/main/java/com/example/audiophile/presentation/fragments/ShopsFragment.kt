package com.example.audiophile.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audiophile.R
import com.example.audiophile.presentation.adapter.StoresAdapter
import com.example.audiophile.databinding.FragmentShopsBinding
import com.example.audiophile.data.network.NetworkService
import com.example.audiophile.presentation.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class ShopsFragment : Fragment(R.layout.fragment_shops) {
    private lateinit var binding: FragmentShopsBinding
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context,exception ->
        binding.progressBar.visibility = View.GONE
        binding.rvShops.adapter =
            StoresAdapter(listOf()) {}
        binding.swRefreshSP.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.parseColor("#ED4337"))
            .setActionTextColor(Color.parseColor("#FFFFFF"))
            .show()
    }

    companion object{
        fun newInstance() = ShopsFragment()
    }
    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopsBinding.bind(view)

        binding.imageClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(
                ProductFragment.newInstance()
            )
        }
        loadShops()

        binding.swRefreshSP.setOnRefreshListener {
            binding.swRefreshSP.isRefreshing = true
            loadShops()
            binding.swRefreshSP.isRefreshing = false
        }
    }
    @ExperimentalSerializationApi
    private fun loadShops() {
        scope.launch {
            val shops = NetworkService.loadStores()
            binding.rvShops.layoutManager = LinearLayoutManager(context)
            binding.rvShops.adapter = StoresAdapter(shops) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshSP.isRefreshing = false
        }
    }
}
