package com.example.final_projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val list: ArrayList<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val tvTask =
            view.findViewById<TextView>(R.id.tv_task)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.activity_list_item,
                parent,
                false
            )

        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {

        holder.tvTask.text =
            list[position].title
    }
}