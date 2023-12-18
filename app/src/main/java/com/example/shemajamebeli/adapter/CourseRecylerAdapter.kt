package com.example.shemajamebeli.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli.databinding.CourseSectionBinding
import com.example.shemajamebeli.model.Course

class CourseRecyclerAdapter :
    RecyclerView.Adapter<CourseRecyclerAdapter.CourseSectionViewHolder>() {

    private lateinit var courseItem: Course

    inner class CourseSectionViewHolder(private val binding: CourseSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(){
                with(binding){
                    val newAdapter = NewCourseRecyclerAdapter()
                    newsRecycler.adapter = newAdapter
                    newsRecycler.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                    newAdapter.submitList(courseItem.new_courses)

                    val activeAdapter = ActiveCourseRecyclerAdapter()
                    currentRecycler.adapter = activeAdapter
                    currentRecycler.layoutManager = LinearLayoutManager(binding.root.context)
                    activeAdapter.submitList(courseItem.active_courses)


                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseSectionViewHolder {
        return CourseSectionViewHolder(
            CourseSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: CourseSectionViewHolder, position: Int) {
        holder.bind()
    }

    fun getItem(item: Course){
        courseItem = item
    }


}