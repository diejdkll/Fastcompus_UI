package com.example.androidui

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class StudentFromServer(
    val id: Int, val name: String, val age: Int, val intro: String
)

interface RetrofitService {
    @GET("json/students/")
    fun getStudentList(): Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<StudentFromServer>
}