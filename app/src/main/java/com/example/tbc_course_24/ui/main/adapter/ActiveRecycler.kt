package com.example.tbc_course_24.ui.main.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_24.databinding.ActiveItemBinding
import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.extensions.setImage

class ActiveRecycler:ListAdapter<CoursesModel.ActiveCourse,ActiveRecycler.ViewHolder>(DiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ActiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: ActiveItemBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var activeCourse: CoursesModel.ActiveCourse

        @SuppressLint("SetTextI18n")
        fun bind(){
            activeCourse = getItem(adapterPosition)

            binding.apply {
                imageView.setImage(activeCourse.image!!)
                cardview.alpha = (activeCourse.backgroundColorPercent!!.toInt()/100.toFloat())
                titleMain.text = activeCourse.title.toString()
                titleSub.text = activeCourse.progress.toString() + "%"
                cardview.setCardBackgroundColor(Color.parseColor("#"+activeCourse.mainColor))
                appCompatButton.setBackgroundColor(Color.parseColor("#"+activeCourse.mainColor))
            }
        }

    }


    class DiffUtilCallback:DiffUtil.ItemCallback<CoursesModel.ActiveCourse>() {
        override fun areItemsTheSame(
            oldItem: CoursesModel.ActiveCourse,
            newItem: CoursesModel.ActiveCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CoursesModel.ActiveCourse,
            newItem: CoursesModel.ActiveCourse
        ): Boolean {
            return oldItem == newItem
        }
    }


}