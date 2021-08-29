package com.hellofresh.task2.ui.common

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.hellofresh.task2.ui.common.model.AlertEvent
import com.hellofresh.task2.ui.common.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val loadingEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertEvent by lazy { SingleLiveEvent<AlertEvent>() }

    protected fun alert(message: String? = null, @StringRes messageRes: Int? = null) {
        alertEvent.value = AlertEvent(
            message = message,
            messageRes = messageRes
        )
    }

    protected fun showLoading() {
        loadingEvent.value = true
    }

    protected fun hideLoading() {
        loadingEvent.value = false
    }
}