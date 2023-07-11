package com.example.schoolinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.schoolinfo.model.remote.ApiService
import com.example.schoolinfo.model.remote.Repository
import com.example.schoolinfo.model.remote.data.SchoolResult
import com.example.schoolinfo.viewmodel.MainViewModel
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
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var schoolListObserver: Observer<List<SchoolResult>>

    @Mock
    lateinit var errorObserver:Observer<String>


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getSchoolListFromApi() returns success`() {
        runTest(StandardTestDispatcher()) {
            val gson = Gson()
            val typeToken = object : TypeToken<List<SchoolResult>>() {}.type
            val fakeResponse = Response.success(
                gson.fromJson<List<SchoolResult>>(Responses.SCHOOL_LIST_RESPONSE, typeToken)
            )
            Mockito.`when`(apiService.getSchoolList()).thenReturn(fakeResponse)

            val repository = Repository(apiService)
            val viewModel = MainViewModel(repository)
            viewModel.schoolLiveData.observeForever(schoolListObserver)
            viewModel.getSchoolListFromApi()

            val expectedResult = Response.success(
                gson.fromJson<List<SchoolResult>>(Responses.SCHOOL_LIST_RESPONSE, typeToken)
            )

            verify(apiService).getSchoolList()
            verify(schoolListObserver).onChanged(expectedResult.body())
            viewModel.schoolLiveData.removeObserver(schoolListObserver)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getInfoBySchool returns failure`() {
        runTest(StandardTestDispatcher()) {
            val fakeResponse = Response.error<String>(500,"{}".toResponseBody(
                "application/json".toMediaTypeOrNull()))

            Mockito.doReturn(fakeResponse).`when`(apiService).getSchoolList()
            val repository = Repository(apiService)
            val viewModel = MainViewModel(repository)
            viewModel.error.observeForever(errorObserver)
            viewModel.getSchoolListFromApi()

            val expectedResult = "Failed to load data."

            verify(apiService).getSchoolList()
            verify(errorObserver).onChanged(expectedResult)
            viewModel.error.removeObserver(errorObserver)
        }
    }
}