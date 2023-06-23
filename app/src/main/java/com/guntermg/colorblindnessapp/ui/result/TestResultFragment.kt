package com.guntermg.colorblindnessapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guntermg.colorblindnessapp.databinding.FragmentTestResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestResultFragment : Fragment() {

    private var _binding: FragmentTestResultBinding? = null
    private val binding: FragmentTestResultBinding get() = _binding!!

    var answerList: ArrayList<Int> = ArrayList()

    private lateinit var recyclerAdapter: TestResultAdapter

    private val KEY_PARSE_DATA = "RESULTS"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestResultBinding
            .inflate(
                inflater,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
//        binding.tvRespostas.text = answerList.toString()
    }

    private fun setupRecyclerView() {
        recyclerAdapter = TestResultAdapter(answerList)
        binding.rvQuestions.adapter = recyclerAdapter
    }
}