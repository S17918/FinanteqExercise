package com.finanteq.exercise.ui.presentation.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finanteq.exercise.R
import com.finanteq.exercise.adapters.TaskRecyclerAdapter
import com.finanteq.exercise.models.Task
import com.finanteq.exercise.util.OnTaskClickListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        subscribeObservers()
    }

    private fun subscribeObservers(){
        viewModel.getTasks().observe(viewLifecycleOwner){
            adapter.setTasks(it)
        }
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

    override fun onTaskClick(pos: Int) {
        val bundle: Bundle = Bundle()
        bundle.putInt("pos", pos)
        findNavController().navigate(R.id.showTaskAction, bundle)
    }

}