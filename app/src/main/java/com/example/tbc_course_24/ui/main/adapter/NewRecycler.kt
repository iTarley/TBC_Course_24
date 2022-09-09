package com.example.tbc_course_24.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_24.databinding.ActiveItemBinding
import com.example.tbc_course_24.databinding.NewItemBinding
import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.extensions.setImage

class NewRecycler: ListAdapter<CoursesModel.NewCourse, NewRecycler.ViewHolder>(DiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            NewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: NewItemBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var newCourse: CoursesModel.NewCourse

        fun bind(){
            newCourse = getItem(adapterPosition)

            binding.apply {
                titleMain.text = newCourse.title
                question.text = newCourse.question
                duration.text = newCourse.duration
                cardview.setCardBackgroundColor(Color.parseColor("#"+newCourse.mainColor))
            }
        }

    }


    class DiffUtilCallback: DiffUtil.ItemCallback<CoursesModel.NewCourse>() {
        override fun areItemsTheSame(
            oldItem: CoursesModel.NewCourse,
            newItem: CoursesModel.NewCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CoursesModel.NewCourse,
            newItem: CoursesModel.NewCourse
        ): Boolean {
            return oldItem == newItem
        }
    }


}