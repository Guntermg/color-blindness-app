package com.guntermg.colorblindnessapp.ui.quest

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.databinding.FragmentQuestBinding
import com.guntermg.colorblindnessapp.ui.model.IshiharaPlate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding: FragmentQuestBinding get() = _binding!!

    private val viewModel: QuestViewModel by viewModels()

    var answerList: ArrayList<Int> = ArrayList()
    var iterator: Int = 0

    private val KEY_PARSE_DATA = "RESULTS"

//    @SuppressLint("UseCompatLoadingForDrawables")
//    private val questions: MutableList<IshiharaPlate> = mutableListOf(
//        IshiharaPlate(R.drawable.plate1, 12, 12),
//        IshiharaPlate(R.drawable.plate2, 8, 3),
//        IshiharaPlate((R.drawable.plate3), 29, 70),
//        IshiharaPlate((R.drawable.plate4), 5, 2),
//        IshiharaPlate((R.drawable.plate5), 3, 5),
//        IshiharaPlate((R.drawable.plate6), 15, 17),
//        IshiharaPlate((R.drawable.plate7), 74, 21),
//        IshiharaPlate((R.drawable.plate8), 6, -1),
//        IshiharaPlate((R.drawable.plate9), 45, -1),
//        IshiharaPlate((R.drawable.plate10), 5, -1),
//        IshiharaPlate((R.drawable.plate11), 7, -1),
//        IshiharaPlate((R.drawable.plate12), 16, -1),
//        IshiharaPlate((R.drawable.plate13), 73, -1),
//    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestBinding
            .inflate(
                inflater,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startupFragment()
        setupNextClickListener()
    }

    private fun startupFragment() {
        binding.ivPlate.setImageResource(IshiharaPlate.questions[iterator].src)
    }

    private fun setupNextClickListener() {
        binding.btnNext.setOnClickListener {
            if (iterator + 1 < IshiharaPlate.questions.size) {
                answerList.add(binding.etAnswer.text.toString().toInt())
                iterator++
                binding.ivPlate.setImageResource(IshiharaPlate.questions[iterator].src)
                Log.e("answerList", answerList.toString())
            } else {
                nextFragment()
            }
        }
    }

    private fun nextFragment() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_questFragment_to_testResultFragment,
                Bundle().apply { putIntegerArrayList(KEY_PARSE_DATA, answerList) }
            )
    }
}