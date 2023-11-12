package com.guntermg.colorblindnessapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.common.BaseVDBFragment
import com.guntermg.colorblindnessapp.common.Constants
import com.guntermg.colorblindnessapp.common.initDarkToolbarFragment
import com.guntermg.colorblindnessapp.databinding.FragmentTestResultBinding
import com.guntermg.colorblindnessapp.ui.model.IshiharaPlate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestResultFragment : BaseVDBFragment<FragmentTestResultBinding>(R.layout.fragment_test_result) {

    var answerList: ArrayList<Int> = ArrayList()

    private lateinit var recyclerAdapter: TestResultAdapter

    private val KEY_PARSE_DATA = "RESULTS"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDarkToolbarFragment(binding.toolbar, getString(R.string.toolbar_test_results))

        arguments?.let {
            val bundle = it.getIntegerArrayList(KEY_PARSE_DATA)
            bundle?.let {
                answerList = bundle
            }
        }

        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        val result = when (gradeResults12Plates()) {
            Constants.PASS -> binding.tvResult.text = getString(R.string.result_normal)
            Constants.PROTANOPY -> binding.tvResult.text = getString(R.string.result_protanopy)
            Constants.DEUTERANOPY -> binding.tvResult.text = getString(R.string.result_deuteranopy)
            Constants.RED_GREEN -> binding.tvResult.text = getString(R.string.result_red_green)
            Constants.FAKED -> binding.tvResult.text = getString(R.string.result_faked)
            else -> {
            }
        }
    }

    private fun setupRecyclerView() {
        recyclerAdapter = TestResultAdapter(answerList)
        binding.rvQuestions.adapter = recyclerAdapter
    }

    private fun gradeResults(): String {
        var correctAnswers = 0
        var fakedFirst = false
        var deuteranopy = 0
        var protanopy = 0
        var redGreen = 0

        answerList.forEachIndexed { position, resposta ->
            if (resposta == IshiharaPlate.questions12Plate[position].number) {
                correctAnswers++
            } else if (position == 0)
                return Constants.FAKED
            else if (IshiharaPlate.questions12Plate[position].relation == Constants.PROTANOPY)
                protanopy++
            else if (IshiharaPlate.questions12Plate[position].relation == Constants.DEUTERANOPY)
                deuteranopy++
            else redGreen++
        }

        return if (correctAnswers < 2) Constants.COLOR_BLIND
        else if (protanopy > 1) Constants.PROTANOPY
        else if (deuteranopy > 1) Constants.DEUTERANOPY
        else if (redGreen > 2) Constants.RED_GREEN
        else Constants.PASS
    }

    private fun gradeResults12Plates(): String {
        var fakedFirst = false
        var inconclusive = 0
        var correctAnswers = 0
        var redGreen = 0
        var protanopy = 0
        var deuteranopy = 0

        answerList.forEachIndexed { position, resposta ->
            if (resposta == IshiharaPlate.questions12Plate[position].number) {
                correctAnswers++
            }
            else if (resposta == IshiharaPlate.questions12Plate[position].possible && position != 0)
                redGreen++
            else if (position == 0) {
                fakedFirst = true
                inconclusive++
            }
            else if (position == 7 ) {
                if (resposta == 2) redGreen++
                else inconclusive++
            }
            else if (position == 10) {
                if (resposta == 5) protanopy++
                if (resposta == 3) deuteranopy++
            }
            else if (position == 11) {
                if (resposta == 6) protanopy++
                if (resposta == 9) deuteranopy++
            }
            else redGreen++
        }
        return if (inconclusive > 0 && fakedFirst) Constants.FAKED
        else if (redGreen > 10) Constants.COLOR_BLIND
        else if (redGreen > 1 && protanopy > 0) Constants.PROTANOPY
        else if (redGreen > 1 && deuteranopy > 0) Constants.DEUTERANOPY
        else if (redGreen > 1) Constants.RED_GREEN
        else Constants.PASS
    }

    private fun returnToMenu() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_testResultFragment_to_menuFragment)
    }
}