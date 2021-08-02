package com.finanteq.exercise.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.*
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(tableName = "tasks")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "name")
    val task_name: String,

    @ColumnInfo(name = "date")
    val task_date: Date,

    @ColumnInfo(name = "category")
    val task_category: String
) : Parcelable {

    constructor(task_name: String, task_date: Date, task_category: String) : this(0, task_name, task_date, task_category)

    companion object {
        const val CATEGORY_1 = "Praca"
        const val CATEGORY_2 = "Zakupy"
        const val CATEGORY_3 = "Dom"
        const val CATEGORY_4 = "Szkoła"
        const val CATEGORY_5 = "Samochód"
        const val CATEGORY_6 = "Inne"
    }
}