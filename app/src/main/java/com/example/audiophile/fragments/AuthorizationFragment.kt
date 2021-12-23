package com.example.audiophile.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.audiophile.R
import com.example.audiophile.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment(R.layout.fragment_authorization){
    companion object{
        fun NewInstance() = AuthorizationFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAuthorizationBinding.bind(view)
    }
}