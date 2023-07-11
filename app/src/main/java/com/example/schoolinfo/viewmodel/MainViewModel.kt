package com.example.schoolinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolinfo.model.remote.Repository
import com.example.schoolinfo.model.remote.data.SchoolResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val schoolLiveData = MutableLiveData<List<SchoolResult>>()
    val error = MutableLiveData<String>()

    fun getSchoolListFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getSchoolList()
                if (response.isSuccessful) {
                    response.body()?.let {
                        schoolLiveData.postValue(it)
                    }
                } else {
                    error.postValue("Failed to load data.")
                }
            } catch (e: Exception) {
                error.postValue(e.toString())
                e.printStackTrace()
            }
        }
    }
}