package com.finanteq.exercise.ui.presentation.task_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.finanteq.exercise.R
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.models.Task.Companion.CATEGORY_1
import com.finanteq.exercise.models.Task.Companion.CATEGORY_2
import com.finanteq.exercise.models.Task.Companion.CATEGORY_3
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class TaskDetailsFragment : Fragment() {

    private val viewModel: TaskDetailsViewModel by viewModel()
    private lateinit var taskName: TextView
    private lateinit var taskCategory: TextView
    private lateinit var taskDate: TextView
    private var pos: Int = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pos = arguments?.getInt("pos")!!
        initTextViews()
        setTextViews()
    }

    private fun initTextViews(){
        taskName = view?.findViewById(R.id.task_details_name)!!
        taskCategory = view?.findViewById(R.id.task_details_category)!!
        taskDate = view?.findViewById(R.id.task_details_date)!!
    }

    private fun setTextViews(){
        viewModel.getTasks().observe(viewLifecycleOwner){
            val format: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            taskName.text = it[pos].task_name
            taskDate.text = format.format(it[pos].task_date)
            taskDate.setBackgroundResource(R.color.date)
            taskCategory.text = it[pos].task_category

            when (it[pos].task_category) {
                CATEGORY_1 -> {
                    taskCategory.setBackgroundResource(R.color.category_1)
                }
                CATEGORY_2 -> {
                    taskCategory.setBackgroundResource(R.color.category_2)
                }
                CATEGORY_3 -> {
                    taskCategory.setBackgroundResource(R.color.category_3)
                }
                Task.CATEGORY_4 -> {
                    taskCategory.setBackgroundResource(R.color.category_4)
                }
                Task.CATEGORY_5 -> {
                    taskCategory.setBackgroundResource(R.color.category_5)
                }
                Task.CATEGORY_6 -> {
                    taskCategory.setBackgroundResource(R.color.category_6)
                }
            }

        }
    }

}