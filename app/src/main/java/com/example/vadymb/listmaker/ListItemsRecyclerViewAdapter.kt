package com.example.vadymb.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ListItemsRecyclerViewAdapter(val list: TaskList) : RecyclerView.Adapter<ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_view_holder, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int = list.tasks.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.textView?.text = list.tasks[position]
    }

}