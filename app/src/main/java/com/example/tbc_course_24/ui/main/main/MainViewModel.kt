package com.example.tbc_course_24.ui.main.main

import androidx.lifecycle.ViewModel
import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.domain.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {


    fun getNewResponse() = flow{
        val response = repository.getResponse().data?.newCourses
        emit(response)
    }
    fun getActiveResponse() = flow{
        val response = repository.getResponse().data?.activeCourses
        emit(response)
    }
}