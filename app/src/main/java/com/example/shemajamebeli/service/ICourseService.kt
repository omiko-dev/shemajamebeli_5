package com.example.shemajamebeli.service

import com.example.shemajamebeli.model.Course
import retrofit2.Response
import retrofit2.http.GET

interface ICourseService {
    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCourses(): Response<Course>
}