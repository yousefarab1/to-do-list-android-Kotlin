package com.example.final_projectapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_projectapp.data.Database

class list_activity : AppCompatActivity() {

    lateinit var etTask: EditText
    lateinit var btnAdd: Button
    lateinit var recycler: RecyclerView

    lateinit var dbHelper: Database

    lateinit var taskList: ArrayList<Task>

    lateinit var adapter: TaskAdapter
    lateinit var btnDeleteAll: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_list)

        etTask = findViewById(R.id.et_task)

        btnAdd = findViewById(R.id.btn_add)

        recycler = findViewById(R.id.recycler_tasks)

        dbHelper = Database(this)
        btnDeleteAll = findViewById(R.id.btn_delete_all)

        taskList = ArrayList()

        val tasksFromDb =
            dbHelper.getAllTasks()

        for (task in tasksFromDb) {

            taskList.add(Task(task))
        }

        adapter = TaskAdapter(taskList)

        recycler.layoutManager =
            LinearLayoutManager(this)

        recycler.adapter = adapter

        btnAdd.setOnClickListener {

            val taskText =
                etTask.text.toString()

            if (taskText.isNotEmpty()) {

                dbHelper.insertTask(taskText)

                taskList.add(Task(taskText))

                adapter.notifyDataSetChanged()

                etTask.text.clear()
            }
        }
        btnDeleteAll.setOnClickListener {

            dbHelper.deleteAllTasks()

            taskList.clear()

            adapter.notifyDataSetChanged()
        }
    }
}