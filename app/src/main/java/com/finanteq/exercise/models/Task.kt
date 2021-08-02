package com.finanteq.exercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Task(
    val task_name: String? = null,
    val task_date: Date? = null,
    val task_category: String? = null
) : Parcelable {
    companion object {
        const val CATEGORY_1 = "Praca"
        const val CATEGORY_2 = "Zakupy"
        const val CATEGORY_3 = "Inne"
    }
}