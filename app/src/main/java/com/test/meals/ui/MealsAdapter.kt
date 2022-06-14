package com.test.meals.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.test.meals.databinding.MealsRowLayoutBinding
import com.test.meals.model.MealCategory

class MealsAdapter:RecyclerView.Adapter<MealsAdapter.ItemViewHolder>(){
    var _mealsList =ArrayList<MealCategory>()

    fun setData(mealsList:ArrayList<MealCategory>){

      _mealsList = mealsList
      notifyItemChanged(mealsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
     val binding = MealsRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
     return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val meal = _mealsList[position]
        holder.bind(meal)

    }

    override fun getItemCount() =_mealsList.size

    class ItemViewHolder(private val binding:MealsRowLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: MealCategory)= with(binding){

          tvMealName.text = meal.name
          ivMeal.load(meal.imageUl)

        }
    }
}