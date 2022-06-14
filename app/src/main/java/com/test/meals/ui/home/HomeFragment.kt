package com.test.meals.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.meals.viewmodel.AppViewModel
import com.test.meals.ui.BannerAdapter
import com.test.meals.ui.MealsAdapter
import com.test.meals.viewmodel.ViewModelFactory
import com.test.meals.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private  var bannerAdapter = BannerAdapter()
    private var mealsAdapter = MealsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val factory = ViewModelFactory()

        val viewModel = ViewModelProvider(this, factory)[AppViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.apply {

            rvMeals.layoutManager =LinearLayoutManager(root.context)
            rvMeals.adapter = mealsAdapter
            viepage.adapter = bannerAdapter
        }

        activity?.intent?.let {intent->

            viewModel.getMealsList(intent.getStringExtra("TOKEN")!!,intent.getIntExtra("USERID",0),"en")

        }?:Toast.makeText(context,"Something went wrong!",Toast.LENGTH_SHORT).show()

        viewModel.mealsResponse.observe(viewLifecycleOwner){

            if(it.status){

              bannerAdapter.setData(it.meal.banners)
              mealsAdapter.setData(it.meal.mealCategory)

            }
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()


        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}