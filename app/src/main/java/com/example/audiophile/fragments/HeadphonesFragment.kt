package com.example.audiophile.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.databinding.FragmentHeadphonesBinding
import com.example.audiophile.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi as ExperimentalSerializationApi

@ExperimentalSerializationApi
class HeadphonesFragment : Fragment(R.layout.fragment_headphones) {
    private lateinit var binding: FragmentHeadphonesBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context,exception ->
        exception.printStackTrace()
        binding.progressBar.visibility = GONE
        binding.rvHeadphones.adapter =
            HeadphoneAdapter(listOf()) {}
        binding.swRefreshHP.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.parseColor("#ED4337"))
            .setActionTextColor(Color.parseColor("#FFFFFF"))
            .show()
    }

    companion object{
        fun newInstance() = HeadphonesFragment()
    }

    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeadphonesBinding.bind(view)

        binding.imageProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(
                ProfileFragment.newInstance()
            )
        }

        loadHeadphone()

        binding.swRefreshHP.setOnRefreshListener {
            binding.swRefreshHP.isRefreshing = true
            loadHeadphone()
            binding.swRefreshHP.isRefreshing = false
        }
    }
    @ExperimentalSerializationApi
    private fun loadHeadphone() {
        scope.launch {
            val headphones = NetworkService.loadHeadphones()
            binding.rvHeadphones.layoutManager = LinearLayoutManager(context)
            binding.rvHeadphones.adapter =
                HeadphoneAdapter(headphones) {
                (activity as MainActivity).navigateToFragment(
                    ProductFragment.newInstance())
            }
            binding.progressBar.visibility = GONE
            binding.swRefreshHP.isRefreshing = false
        }
    }

}