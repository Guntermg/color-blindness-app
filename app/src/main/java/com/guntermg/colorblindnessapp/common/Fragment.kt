package com.guntermg.colorblindnessapp.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController

/**
 * Observers the given [state] and executes a back navigation
 *
 * @param state The navigate Navigate state bo be observed
 */
fun Fragment.observeNavBack(
    state: LiveData<Boolean>
) {
    state.observe(viewLifecycleOwner) { navigateBack ->
        if (navigateBack.handleOpt()) {
            findNavController().popBackStack()
        }
    }
}