package com.guntermg.colorblindnessapp.common

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.guntermg.colorblindnessapp.R

fun Fragment.initDarkToolbarFragment(
    toolbar: Toolbar?,
    title: String? = "",
    finishActivityWhenBackPressed: Boolean = false,
) {
    (requireActivity() as AppCompatActivity?)!!.setSupportActionBar(toolbar)
    requireActivity().title = title ?: ""
    (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar?.setNavigationOnClickListener {
        if (finishActivityWhenBackPressed) {
            requireActivity().finish()
        } else
            requireActivity().onBackPressedDispatcher.onBackPressed()
    }
    toolbar?.setTitleTextColor(ContextCompat.getColor(requireActivity(), R.color.black))
}
