package com.hellofresh.task2.ui.common.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.Exception

object DateUtils {

    private const val displayDatePattern = "dd MMM"
    private val displayDateFormat by lazy {
        SimpleDateFormat(displayDatePattern, Locale.getDefault())
    }

    fun toDisplayFormat(date: Date): String {
        return try {
            displayDateFormat.format(date)
        } catch (e: Exception) {
            "N/A"
        }
    }
}