package com.example.tbc_course_24.domain.repository

import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.network.ApiInterface
import com.example.tbc_course_24.utils.Resource
import java.lang.Exception

class ApiRepository ( private val api: ApiInterface) {


    suspend fun getResponse():Resource<CoursesModel?>{
        return try {
            Resource.loading(null)
            val response = api.getResponse()
            val result = response.body()
            if (response.isSuccessful){
                Resource.success(result)
            }else{
                Resource.error(response.message())
            }
        }catch (e:Exception){
            Resource.error(e.message.toString())
        }
    }
}