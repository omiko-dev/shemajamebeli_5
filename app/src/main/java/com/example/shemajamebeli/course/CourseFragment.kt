package com.example.shemajamebeli.course

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli.BaseFragment
import com.example.shemajamebeli.adapter.CourseRecyclerAdapter
import com.example.shemajamebeli.common.Resource
import com.example.shemajamebeli.databinding.FragmentCourseBinding
import kotlinx.coroutines.launch


class CourseFragment : BaseFragment<FragmentCourseBinding>(FragmentCourseBinding::inflate) {
    private val viewModel: CourseViewModel by viewModels()
    private lateinit var adapter: CourseRecyclerAdapter

    override fun bind() {
        getCourse()
        getObserve()
    }

    private fun getCourse() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getCourse()
        }
    }

    private fun setUpRecycler() {
        adapter = CourseRecyclerAdapter()
        with(binding) {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun getObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.courseStateFlow.collect {
                    when(it){
                        is Resource.Success -> {
                            setUpRecycler()
                            adapter.getItem(it.successData)
                        }
                        is Resource.Error -> {

                        }
                        Resource.Idle -> {}
                    }
                }
            }
        }
    }
}


