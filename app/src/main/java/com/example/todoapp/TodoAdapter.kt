package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }
    override fun getItemCount() = list.size
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: TodoModel) {
            with(itemView) {
                val color = resources.getIntArray(R.array.random_color)
                val randomColor = color[Random().nextInt(color.size)]
                val viewColorTag = itemView.findViewById<View>(R.id.viewColorTag)
                var txtShowTitle = itemView.findViewById<TextView>(R.id.txtShowTitle)
                var txtShowTask = itemView.findViewById<TextView>(R.id.txtShowTask)
                var txtShowCategory = itemView.findViewById<TextView>(R.id.txtShowCategory)
                viewColorTag.setBackgroundColor(randomColor)
                txtShowTitle.text = todoModel.title
                txtShowTask.text = todoModel.description
                txtShowCategory.text = todoModel.category
                updateTime(todoModel.time)
                updateDate(todoModel.date)
            }
        }

        private fun updateTime(time: Long) {
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            val txtShowTime = itemView.findViewById<TextView>(R.id.txtShowTime)
            txtShowTime.text = sdf.format(Date(time))
        }

        private fun updateDate(date: Long) {
            val myformat = "EEE, DD MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            val txtShowDate = itemView.findViewById<TextView>(R.id.txtShowDate)
            txtShowDate.text = sdf.format(Date(date))
        }

    }

}


