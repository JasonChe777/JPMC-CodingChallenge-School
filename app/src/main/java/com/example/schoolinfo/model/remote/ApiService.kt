package com.example.schoolinfo.model.remote

import com.example.schoolinfo.model.remote.Constants.INFO_ENDPOINT
import com.example.schoolinfo.model.remote.Constants.SCHOOL_ENDPOINT
import com.example.schoolinfo.model.remote.data.InfoResult
import com.example.schoolinfo.model.remote.data.SchoolResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(SCHOOL_ENDPOINT)
    suspend fun getSchoolList(): Response<List<SchoolResult>>

    @GET(INFO_ENDPOINT)
    suspend fun getSchoolInfo(@Query("dbn") dbn: String): Response<List<InfoResult>>
}