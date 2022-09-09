package com.example.tbc_course_24.network

import com.example.tbc_course_24.domain.model.CoursesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getResponse(): Response<CoursesModel>
}