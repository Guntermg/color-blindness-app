package com.guntermg.colorblindnessapp.ui.quest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.common.BaseVDBFragment
import com.guntermg.colorblindnessapp.common.initDarkToolbarFragment
import com.guntermg.colorblindnessapp.databinding.FragmentBeforeQuestsBinding
import com.guntermg.colorblindnessapp.ui.model.IshiharaPlate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeforeQuestsFragment :
    BaseVDBFragment<FragmentBeforeQuestsBinding>(R.layout.fragment_before_quests) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDarkToolbarFragment(binding.toolbar, getString(R.string.toolbar_which_number))

//        startupFragment()
        setupNextClickListener()
    }

    private fun setupNextClickListener() {
        binding.btnNext.setOnClickListener {
            if (findNavController().currentDestination?.id == R.id.beforeQuestsFragment) {
                NavHostFragment.findNavController(this)
                    .navigate(
                        R.id.action_beforeQuestsFragment_to_questFragment
                    )
            }
        }
    }
}