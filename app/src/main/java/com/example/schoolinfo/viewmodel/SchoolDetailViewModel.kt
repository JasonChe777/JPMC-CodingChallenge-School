package com.example.schoolinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolinfo.model.remote.Repository
import com.example.schoolinfo.model.remote.data.InfoResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val infoLiveData = MutableLiveData<List<InfoResult>>()
    val error = MutableLiveData<String>()

    fun getInfoBySchool(dbn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getSchoolInfo(dbn)
                if (response.isSuccessful) {
                    response.body()?.let {
                        infoLiveData.postValue(it)
                    }
                } else {
                    error.postValue("Unrecognized dbn.")
                }
            } catch (e: Exception) {
                error.postValue(e.toString())
                e.printStackTrace()
            }
        }
    }
}