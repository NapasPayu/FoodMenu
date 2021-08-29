package com.hellofresh.task2.ui.common

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.hellofresh.task2.R
import com.hellofresh.task2.ui.common.model.AlertEvent

abstract class BaseFragment : Fragment() {

    protected fun showAlert(alertEvent: AlertEvent) {
        view?.let {
            Snackbar.make(
                it,
                alertEvent.message ?: alertEvent.messageRes?.let(this::getString)
                ?: getString(R.string.generic_error),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}