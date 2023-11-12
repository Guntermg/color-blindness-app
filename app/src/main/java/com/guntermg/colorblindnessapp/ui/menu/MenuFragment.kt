package com.guntermg.colorblindnessapp.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.databinding.FragmentMenuBinding
import com.guntermg.colorblindnessapp.databinding.FragmentQuestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!

    private val viewModel: MenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding
            .inflate(
                inflater,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        setupIshiharaTestClickListener()
        setupGeometricIshiharaClickListener()
        setupAboutIshiharaClickListener()
    }

    private fun setupIshiharaTestClickListener() {
        binding.cvFirstItem.setOnClickListener {
            if (findNavController().currentDestination?.id == R.id.menuFragment) {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_menuFragment_to_beforeQuestsFragment)
            }
        }
    }

    private fun setupGeometricIshiharaClickListener() {
        binding.cvSecondItem.setOnClickListener {
            Toast.makeText(
                this.context,
                "Esta seção ainda não está pronta.",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    private fun setupAboutIshiharaClickListener() {
        binding.cvAboutIshihara.setOnClickListener {
            if (findNavController().currentDestination?.id == R.id.menuFragment) {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_menuFragment_to_aboutFragment)
            }
        }
    }

}