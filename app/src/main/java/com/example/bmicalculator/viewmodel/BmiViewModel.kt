package com.example.bmicalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmicalculator.model.BmiData
import com.example.bmicalculator.repository.BmiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class BmiViewModel @Inject constructor(
    private val bmiRepository: BmiRepository) : ViewModel()
{
        private var _bmiData = MutableLiveData<BmiData>()
    val bmiData: LiveData<BmiData> = _bmiData

    fun calculateBmi(weight: Double, height: Double) {
        val result = bmiRepository.calculateBmi(weight, height)
        _bmiData.value = result
    }
}