package com.example.audiophile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.audiophile.R
import com.example.audiophile.databinding.MainActivityBinding
import com.example.audiophile.presentation.fragments.HeadphonesFragment

class MainActivity : FragmentActivity() {
    fun navigateToFragment(fmt: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fmt)
            .addToBackStack(fmt.javaClass.name)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateToFragment(HeadphonesFragment.newInstance())
        }
    }
}