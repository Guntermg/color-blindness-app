package com.guntermg.colorblindnessapp.ui.quest

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.common.BaseVDBFragment
import com.guntermg.colorblindnessapp.common.Utils
import com.guntermg.colorblindnessapp.common.initDarkToolbarFragment
import com.guntermg.colorblindnessapp.databinding.FragmentQuestBinding
import com.guntermg.colorblindnessapp.ui.model.IshiharaPlate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestFragment : BaseVDBFragment<FragmentQuestBinding>(R.layout.fragment_quest) {

    private val viewModel: QuestViewModel by viewModels()

    var answerList: ArrayList<Int> = ArrayList()
    var iterator: Int = 0

    private val KEY_PARSE_DATA = "RESULTS"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDarkToolbarFragment(binding.toolbar, getString(R.string.toolbar_which_number))


        startupFragment()
        setupNextClickListener()
    }

    private fun startupFragment() {
        binding.ivPlate.setImageResource(IshiharaPlate.questions12Plate[iterator].src)
    }

    private fun setupNextClickListener() {
        binding.btnNext.setOnClickListener {
            if (!binding.etAnswer.text.isNullOrBlank()) {
                if (iterator + 1 < IshiharaPlate.questions12Plate.size) {
                    answerList.add(binding.etAnswer.text.toString().toInt())
                    nextImage()
                } else {
                    nextFragment()
                }
            } else {
                Toast.makeText(
                    this.context,
                    getString(R.string.toast_sem_resposta),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnNoNumber.setOnClickListener {
            if (iterator + 1 < IshiharaPlate.questions12Plate.size) {
                // adding -1 to list, as plate not recognized
                answerList.add(-1)
                nextImage()
            } else {
                nextFragment()
            }
        }
    }

    private fun nextImage() {
        iterator++
        binding.ivPlate.setImageResource(IshiharaPlate.questions12Plate[iterator].src)
        binding.etAnswer.text.clear()
        Log.e("answerList", answerList.toString())
    }

    private fun nextFragment() {
        if (findNavController().currentDestination?.id == R.id.questFragment) {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_questFragment_to_testResultFragment,
                    Bundle().apply { putIntegerArrayList(KEY_PARSE_DATA, answerList) }
                )
        }
    }
}