package com.guntermg.colorblindnessapp.ui.about

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.common.BaseVDBFragment
import com.guntermg.colorblindnessapp.common.initDarkToolbarFragment
import com.guntermg.colorblindnessapp.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BaseVDBFragment<FragmentAboutBinding>(R.layout.fragment_about) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDarkToolbarFragment(binding.toolbar, getString(R.string.about_ishihara))

        setupBackClickListener()
    }

    private fun setupBackClickListener() {
        binding.btnNext.setOnClickListener {
            if (findNavController().currentDestination?.id == R.id.aboutFragment) {
                NavHostFragment.findNavController(this)
                    .navigate(
                        R.id.action_aboutFragment_to_menuFragment
                    )
            }
        }
    }
}