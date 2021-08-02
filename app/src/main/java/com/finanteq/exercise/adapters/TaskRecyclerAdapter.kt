package com.finanteq.exercise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.finanteq.exercise.R
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.models.Task.Companion.CATEGORY_1
import com.finanteq.exercise.models.Task.Companion.CATEGORY_2
import com.finanteq.exercise.models.Task.Companion.CATEGORY_3
import com.finanteq.exercise.util.OnTaskClickListener
import java.text.SimpleDateFormat

class TaskRecyclerAdapter(private val clickListener: OnTaskClickListener) : RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder>(){

    private var taskList: List<Task> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        if(taskList.isNotEmpty()){
            return taskList.size
        }
        return 0
    }

    fun setTasks(list: List<Task>){
        taskList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View, val clickListener: OnTaskClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var taskName: TextView? = null
        private var taskCategory: TextView? = null
        private var taskDate: TextView? = null

        init {
            taskName = itemView.findViewById(R.id.task_name)
            taskCategory = itemView.findViewById(R.id.task_category)


            taskDate = itemView.findViewById(R.id.task_date)
            itemView.setOnClickListener(this)
        }

        fun bind(task: Task){
            taskName?.text = task.task_name
            taskCategory?.text = task.task_category

            val format: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            taskDate?.text = format.format(task.task_date)

            taskDate?.setBackgroundResource(R.color.date)

            when (task.task_category) {
                CATEGORY_1 -> {
                    taskCategory?.setBackgroundResource(R.color.category_1)
                }
                CATEGORY_2 -> {
                    taskCategory?.setBackgroundResource(R.color.category_2)
                }
                CATEGORY_3 -> {
                    taskCategory?.setBackgroundResource(R.color.category_3)
                }
            }
        }

        override fun onClick(v: View?) {
            clickListener.onTaskClick(adapterPosition)
        }

    }
}