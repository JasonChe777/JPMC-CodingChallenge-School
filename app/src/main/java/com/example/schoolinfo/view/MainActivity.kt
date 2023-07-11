package com.example.schoolinfo.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.schoolinfo.databinding.ActivityMainBinding
import com.example.schoolinfo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SchoolAdapter
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpObserver()
        viewModel.getSchoolListFromApi()
    }

    private fun setUpObserver() {
        viewModel.schoolLiveData.observe(this@MainActivity) { it ->
            binding.rvSchoolList.layoutManager = LinearLayoutManager(this)
            adapter = SchoolAdapter(it)
            binding.rvSchoolList.adapter = adapter
            adapter.setOnItemSelectedListener { schoolResult ->
                val intent = Intent(this@MainActivity, SchoolDetailActivity::class.java)
                intent.putExtra("school", schoolResult)
                startActivity(intent)
            }

            adapter.setOnWebLinkClickedListener { it ->
                val intent = Intent(Intent.ACTION_VIEW)
                if (it.contains("http://") || it.contains("https://")) {
                    intent.data = Uri.parse(it)
                } else {
                    val url = "https://$it"
                    intent.data = Uri.parse(url)
                }
                startActivity(intent)
            }
        }

    }
}