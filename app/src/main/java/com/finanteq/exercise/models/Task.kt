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
}