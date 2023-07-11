package com.example.schoolinfo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolinfo.databinding.ItemSchoolBinding
import com.example.schoolinfo.model.remote.data.SchoolResult

class SchoolAdapter(private var result: List<SchoolResult>) :
    RecyclerView.Adapter<SchoolViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSchoolBinding.inflate(layoutInflater, parent, false)
        return SchoolViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val info = result[position]
        holder.bind(info)
        holder.binding.btnShowDetails.setOnClickListener {
            if (this::itemSelected.isInitialized) {
                itemSelected(info)
            }
        }

        holder.binding.tvSchoolWebsite.setOnClickListener {
            if (this::webLinkSelect.isInitialized){
                webLinkSelect(info.website)
            }
        }
    }

    private lateinit var itemSelected: (SchoolResult) -> Unit
    private lateinit var webLinkSelect: (String) -> Unit

    fun setOnItemSelectedListener(listener: (SchoolResult) -> Unit) {
        itemSelected = listener
    }

    fun setOnWebLinkClickedListener(listener: (String) -> Unit){
        webLinkSelect = listener
    }

    override fun getItemCount(): Int {
        return result.size
    }
}