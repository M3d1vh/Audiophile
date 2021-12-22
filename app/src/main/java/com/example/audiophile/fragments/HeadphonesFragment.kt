package com.example.audiophile.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.adapter.HeadphoneAdapter
import com.example.audiophile.data.DataSource
import com.example.audiophile.databinding.FragmentHeadphonesBinding

class HeadphonesFragment : Fragment(R.layout.fragment_headphones) {
    companion object{
        private const val KEY_ARG_STRING = "KEY_ARG_STRING"
        private const val KEY_ARG_LONG = "KEY_ARG_LONG"
        private const val KEY_ARG_BOOL = "KEY_ARG_BOOL"
        fun newInstance(argString: String, argLong: Long, argBool: Boolean) : HeadphonesFragment {
            val args = bundleOf(
                KEY_ARG_STRING to argString,
                KEY_ARG_LONG to argLong,
                KEY_ARG_BOOL to argBool,
            )
            val fragment = HeadphonesFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argString = arguments?.getString(KEY_ARG_STRING)
        val argLong = arguments?.getString(KEY_ARG_LONG)
        val argBool = arguments?.getString(KEY_ARG_BOOL)

        val binding = FragmentHeadphonesBinding.bind(view)
        binding.rvHeadphones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHeadphones.adapter = HeadphoneAdapter(DataSource.Headphones) { (model, description, iconResId) ->

        }
    }
}