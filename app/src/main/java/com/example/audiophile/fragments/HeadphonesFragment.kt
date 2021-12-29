package com.example.audiophile.fragments


import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audiophile.R
import com.example.audiophile.ScreenState
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.databinding.FragmentHeadphonesBinding
import com.example.audiophile.model.Headphone
import com.example.audiophile.network.NetworkService
import com.example.audiophile.onClickFlow
import com.example.audiophile.onRefreshFlow
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.Collections.replaceAll
import kotlinx.serialization.ExperimentalSerializationApi as ExperimentalSerializationApi

@ExperimentalCoroutinesApi
@ExperimentalSerializationApi
class HeadphonesFragment : Fragment(R.layout.fragment_headphones)  {
private lateinit var binding: FragmentHeadphonesBinding

    companion object{
        fun newInstance() = HeadphonesFragment()
    }

    private fun setLoading(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading && !rvHeadphones.isVisible
        swRefreshHP.isRefreshing = isLoading && rvHeadphones.isVisible
    }
    private fun setData(headphones: List<Headphone>?) = with(binding){
        rvHeadphones.isVisible = headphones != null
        binding.rvHeadphones.layoutManager = LinearLayoutManager(context)
        rvHeadphones.adapter =
            HeadphoneAdapter(headphones ?: listOf()){
                (activity as MainActivity).navigateToFragment(
                    ProductFragment.newInstance())
            }
        binding.imageProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(
                ProfileFragment.newInstance()
            )
        }
    }
    private fun setError(message: String?) = with(binding){
        ErrLayout.isVisible = message != null
        textError.text = message
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeadphonesBinding.bind(view)
        merge(
            flowOf(Unit),
            binding.swRefreshHP.onRefreshFlow(),
            binding.buttonError.onClickFlow()
        )
            .flatMapLatest{loadHeadphone()}
            .distinctUntilChanged()
            .onEach{
                when(it){
                    is ScreenState.DataLoaded -> {
                        setLoading(false)
                        setError(null)
                        setData(it.headphones)
                    }
                    is ScreenState.Error -> {
                        setLoading(false)
                        setError(it.error)
                        setData(null)
                    }
                    ScreenState.Loading -> {
                        setLoading(true)
                        setError(null)
                    }
                }
            }
            .launchIn(lifecycleScope)
    }
    @ExperimentalSerializationApi
    private fun loadHeadphone() = flow {

        emit(ScreenState.Loading)
        val headphone = NetworkService.loadHeadphones()
        emit(ScreenState.DataLoaded(headphone))
    }
        .catch{
            emit(ScreenState.Error(getString(R.string.error_connect)))
        }
}