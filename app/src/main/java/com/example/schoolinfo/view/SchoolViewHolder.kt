package com.example.schoolinfo.view

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.schoolinfo.databinding.ItemSchoolBinding
import com.example.schoolinfo.model.remote.data.SchoolResult

class SchoolViewHolder(val binding: ItemSchoolBinding) : ViewHolder(binding.root) {
    fun bind(schoolResult: SchoolResult) {
        binding.tvSchoolName.text = schoolResult.school_name
        binding.tvSchoolWebsite.text = schoolResult.website
        binding.tvSchoolWebsite.paintFlags =
            binding.tvSchoolWebsite.paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }

}