package com.finanteq.exercise.ui.presentation.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finanteq.exercise.R
import com.finanteq.exercise.adapters.TaskRecyclerAdapter
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.util.OnTaskClickListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class TaskListFragment : Fragment(), OnTaskClickListener {

    private val viewModel: TaskListViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskRecyclerAdapter
    private lateinit var addButton: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        initFloatingButton()
        adapter.setTasks(initTestData())

    }

    private fun initRecyclerView(){
        recyclerView = requireView().findViewById(R.id.task_list)
        adapter = TaskRecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun initFloatingButton(){
        addButton = requireView().findViewById(R.id.addTaskButton)
        addButton.setOnClickListener {
            findNavController().navigate(R.id.addTaskAction)
        }
    }

    private fun initTestData(): List<Task> {
        val date: Date = Calendar.getInstance().time
        val task1: Task = Task("Zadanie numer 1", date, "Category 1")
        val task2: Task = Task("Zadanie numer 2", date, "Category 2")
        val task3: Task = Task("Zadanie numer 3", date, "Category 3")
        val task4: Task = Task("Zadanie numer 4", date, "Category 4")
        val task5: Task = Task("Zadanie numer 5", date, "Category 2")

        return listOf(task1, task2, task3, task4, task5)
    }

    override fun onTaskClick(pos: Int) {
        val task: Task = initTestData()[pos]
        val bundle: Bundle = Bundle()
        bundle.putParcelable("task", task)
        findNavController().navigate(R.id.showTaskAction, bundle)
    }

}