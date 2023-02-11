package com.example.gymtracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymtracker.databinding.TrainingBoxBinding
import com.example.gymtracker.entities.Date
import com.example.gymtracker.entities.Training

class TrainingAdapter(var trainings : List<Training>) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {
    inner class TrainingViewHolder(val binding: TrainingBoxBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TrainingBoxBinding.inflate(layoutInflater, parent, false)
        return TrainingViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return trainings.size
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.binding.apply {
            tvExerciseBOX.text = trainings[position].exercise
            tvKgBOX.text = trainings[position].kg
                    try {
                        if (trainings[position].date!=trainings[position-1].date) {
                            tvDateBOX.text = trainings[position].date
                        }
                        else{
                            tvDateBOX.visibility = View.GONE
                        }
                    }catch (e: java.lang.IndexOutOfBoundsException){
                        tvDateBOX.text = trainings[position].date
                }
        }
    }

}