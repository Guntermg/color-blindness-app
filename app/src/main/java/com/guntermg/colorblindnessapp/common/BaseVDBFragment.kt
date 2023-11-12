package com.guntermg.colorblindnessapp.common

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * A base fragment that handles the UI inflate and exposes its binding as a property.
 * @param layoutRes to be inflated
 * @property binding can be used to connect the ViewModel
 */
abstract class BaseVDBFragment<VDD : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : Fragment() {
    /**
     * Data binding that must be used to connect the ViewModel and to handle UI behaviours that
     * cannot be handled by the ViewModel/XML file directly
     */
    lateinit var binding: VDD

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutRes,
            container,
            false
        )
        binding.lifecycleOwner= viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupViewModel()?.let { observeNavBack(it.navigateBack) }
//        setupObservers()
    }

    /**
     * To be able to visualize the navigation flow when entering each fragment
     * passing a log with the name of the current fragment.
     */
    override fun onStart() {
        super.onStart()
        Log.d("NAVIGATION_SCREEN", this.javaClass.simpleName)
    }

    /**
     * Override this method to connect the ViewModel to the binding
     */
//    abstract fun setupViewModel():BaseViewModel?

    /**
     * Override this method to oberve all the states exposed by the ViewModel
     */
//    abstract fun setupObservers()

}