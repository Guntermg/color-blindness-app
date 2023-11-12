package com.guntermg.colorblindnessapp.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.withContext

/**
 * Base [ViewModel] that handles the [navigateBack] click and exposes its state
 *
 */
abstract class BaseViewModel : ViewModel() {
    protected val channel = Channel<BaseViewModelStatus>()
    private val _navigateBack = MutableLiveData<Boolean>()
    val loading = MutableLiveData(false)
    val triggers = channel.receiveAsFlow()
    val navigateBack: LiveData<Boolean> = _navigateBack

    fun onNavigateBackClick() {
        _navigateBack.value = true
    }

    suspend fun setLoading(isVisible: Boolean) = withContext(Dispatchers.Main) {
        if (isVisible && loading.value == false) {
            loading.value = true
        } else if (!isVisible && loading.value == true) {
            loading.value = false
        }
    }

    sealed class BaseViewModelStatus {
        data class OnLoadSuccess(val data: Any?) : BaseViewModelStatus()
        object OnLoadFail : BaseViewModelStatus()
    }
}