package com.example.shemajamebeli.course

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli.common.Resource
import com.example.shemajamebeli.model.Course
import com.example.shemajamebeli.network.Network
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class CourseViewModel: ViewModel() {
    private var _courseStateFlow = MutableStateFlow<Resource<Course>>(Resource.Idle)
    val courseStateFlow = _courseStateFlow.asStateFlow()

    fun getCourse(){
        viewModelScope.launch {
            val response = Network.courseService().getCourses()

            try {
                if(response.isSuccessful){
                    _courseStateFlow.value = Resource.Success(response.body()!!)
                }else{
                    _courseStateFlow.value = Resource.Error(response.errorBody()?.toString())
                }
            }catch (e: UnknownHostException){
                Log.i("omiko", e.toString())
            }

        }
    }
}