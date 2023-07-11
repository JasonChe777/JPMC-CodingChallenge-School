package com.example.schoolinfo.model.remote

import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun getSchoolList() = apiService.getSchoolList()
    suspend fun getSchoolInfo(dbn: String) = apiService.getSchoolInfo(dbn)
}