package com.example.schoolinfo.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.schoolinfo.R
import com.example.schoolinfo.databinding.ActivitySchoolDetailBinding
import com.example.schoolinfo.model.remote.data.SchoolResult
import com.example.schoolinfo.viewmodel.SchoolDetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchoolDetailBinding
    private val viewModel: SchoolDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = intent.extras?.getParcelable<SchoolResult>("school")
        setUpObserver()
        info?.dbn?.let { viewModel.getInfoBySchool(it) }

        setSupportActionBar(binding.satScoreToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        binding.satScoreToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setUpObserver() {
        viewModel.infoLiveData.observe(this) {
            binding.apply {
                if (it.isEmpty()) {
                    Snackbar.make(root,"No Data Found!", Snackbar.LENGTH_LONG).show()
                    return@observe
                }
                it?.let {
                    val satInfo = it[0]
                    tvSchoolName.text = satInfo.school_name
                    tvNumTestTaker.text = String.format("Number of Test Taker: ${satInfo.num_of_sat_test_takers}")
                    tvMathScore.text = String.format("Average Math Score: ${satInfo.sat_math_avg_score}")
                    tvReadingScore.text = String.format("Average Reading Score: ${satInfo.sat_critical_reading_avg_score}")
                    tvWritingScore.text = String.format("Average Writing Score: ${satInfo.sat_writing_avg_score}")
                }
            }
        }
    }
}