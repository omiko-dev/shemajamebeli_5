package com.example.shemajamebeli.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli.databinding.NewCourseCardBinding
import com.example.shemajamebeli.model.NewCourse

class NewCourseRecyclerAdapter :
    ListAdapter<NewCourse, NewCourseRecyclerAdapter.NewCourseViewHolder>(CourseDiffUtil) {

    companion object {
        private val CourseDiffUtil = object : DiffUtil.ItemCallback<NewCourse>() {
            override fun areItemsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class NewCourseViewHolder(private val binding: NewCourseCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(){
                with(binding){
                    val item = currentList[adapterPosition]
                    tvTitle.text = item.title
                    tvDuration.text = item.duration
                    tvQuestion.text = item.question
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCourseViewHolder {
        return NewCourseViewHolder(
            NewCourseCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewCourseViewHolder, position: Int){
        holder.bind()
    }
}