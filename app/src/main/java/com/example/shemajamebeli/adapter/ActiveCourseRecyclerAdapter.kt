package com.example.shemajamebeli.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli.databinding.CurrentCourseCardBinding
import com.example.shemajamebeli.model.ActiveCourse

class ActiveCourseRecyclerAdapter :
    ListAdapter<ActiveCourse, ActiveCourseRecyclerAdapter.CourseSectionViewHolder>(CourseDiffUtil) {

    companion object {
        private val CourseDiffUtil = object : DiffUtil.ItemCallback<ActiveCourse>() {
            override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class CourseSectionViewHolder(private val binding: CurrentCourseCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(){
                with(binding){
                    val item = currentList[adapterPosition]
                    tvOne.text = item.booking_time
                    tvTwo.text = item.booking_time
                    Glide.with(this.root)
                        .load(item.image)
                        .into(ivImage)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseSectionViewHolder {
        return CourseSectionViewHolder(
            CurrentCourseCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CourseSectionViewHolder, position: Int) {
        holder.bind()
    }


}