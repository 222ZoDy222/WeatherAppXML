package com.zdy.myapplication.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zdy.myapplication.DataClasses.DayWeather
import com.zdy.myapplication.databinding.ItemHoursListBinding

class HoursViewAdapter : ListAdapter<DayWeather, HoursViewAdapter.HoursViewHolder>(Comporator()) {


    class HoursViewHolder(
        val binding : ItemHoursListBinding
    ) : RecyclerView.ViewHolder(binding.root)
    {

        fun Init(dayWeather: DayWeather) = with(binding){
            timeText.text = dayWeather.time.split(" ")[1]
            temperatureText.text = dayWeather.currentTemp
            Picasso.get().load("https:" + dayWeather.imageURL).into(imageView)

        }

    }

    class Comporator : DiffUtil.ItemCallback<DayWeather>(){
        override fun areItemsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHoursListBinding.inflate(inflater,parent,false)

        return HoursViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        holder.Init(getItem(position))
    }

}