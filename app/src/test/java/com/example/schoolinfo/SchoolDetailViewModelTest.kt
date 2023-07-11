package com.example.schoolinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.schoolinfo.model.remote.ApiService
import com.example.schoolinfo.model.remote.Repository
import com.example.schoolinfo.model.remote.data.InfoResult
import com.example.schoolinfo.viewmodel.SchoolDetailViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class SchoolDetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var schoolDetailsObserver: Observer<List<InfoResult>>

    @Mock
    lateinit var errorObserver:Observer<String>

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getInfoBySchool() returns success`(){
        runTest(StandardTestDispatcher()) {

            val gson = Gson()
            val typeToken = object : TypeToken<List<InfoResult>>() {}.type
            val fakeResponse = Response.success(
                gson.fromJson<List<InfoResult>>(Responses.SCHOOL_LIST_RESPONSE, typeToken)
            )
            Mockito.`when`(apiService.getSchoolInfo("01M448")).thenReturn(fakeResponse)
            val repository = Repository(apiService)
            val viewModel = SchoolDetailViewModel(repository)
            viewModel.infoLiveData.observeForever(schoolDetailsObserver)
            viewModel.getInfoBySchool("01M448")

            val expectedResult = Response.success(
                gson.fromJson<List<InfoResult>>(Responses.SCHOOL_LIST_RESPONSE, typeToken)
            )

            verify(apiService).getSchoolInfo("01M448")
            verify(schoolDetailsObserver).onChanged(expectedResult.body())
            viewModel.infoLiveData.removeObserver(schoolDetailsObserver)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getSchoolListFromApi() returns failure`() {
        runTest(StandardTestDispatcher()) {
            val fakeResponse = Response.error<String>(500,"{}".toResponseBody(
                "application/json".toMediaTypeOrNull()))

            Mockito.doReturn(fakeResponse).`when`(apiService).getSchoolInfo("abcd")
            val repository = Repository(apiService)
            val viewModel = SchoolDetailViewModel(repository)
            viewModel.error.observeForever(errorObserver)
            viewModel.getInfoBySchool("abcd")

            val expectedResult = "Unrecognized dbn."

            verify(apiService).getSchoolInfo("abcd")
            verify(errorObserver).onChanged(expectedResult)
            viewModel.error.removeObserver(errorObserver)
        }
    }
}