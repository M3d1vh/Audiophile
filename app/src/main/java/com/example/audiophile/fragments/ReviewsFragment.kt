package com.example.audiophile.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.adapter.ReviewAdapter
import com.example.audiophile.databinding.FragmentReviewsBinding
import com.example.audiophile.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class ReviewsFragment : Fragment(R.layout.fragment_reviews) {
    private lateinit var binding: FragmentReviewsBinding
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context,exception ->
        binding.progressBar.visibility = View.GONE
        binding.rvReviews.adapter =
            HeadphoneAdapter(listOf()) {}
        binding.swRefreshRW.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.parseColor("#ED4337"))
            .setActionTextColor(Color.parseColor("#FFFFFF"))
            .show()
    }

    companion object{
        fun newInstance() = ReviewsFragment()
    }

    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReviewsBinding.bind(view)

        binding.imageClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(
                ProductFragment.newInstance()
            )
        }
        loadReview()

        binding.swRefreshRW.setOnRefreshListener {
            binding.swRefreshRW.isRefreshing = true
            loadReview()
            binding.swRefreshRW.isRefreshing = false
        }
    }
    @ExperimentalSerializationApi
    private fun loadReview() {
        scope.launch {
            val reviews = NetworkService.loadReviews()
            binding.rvReviews.layoutManager = LinearLayoutManager(context)
            binding.rvReviews.adapter = ReviewAdapter(reviews) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshRW.isRefreshing = false
        }
    }
}