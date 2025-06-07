package com.example.bmicalculator.repository

import com.example.bmicalculator.model.BmiData
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlin.math.pow

@Singleton
class BmiRepository @Inject constructor() {

    fun calculateBmi(weight: Double, height: Double): BmiData {
        // tinggi dalam meter
        val heightInMeters = height / 100
        val bmi = weight / heightInMeters.pow(2)

        val category = when {
            bmi < 18.5 -> "Kurus"
            bmi in 18.5..24.9 -> "Normal"
            bmi in 25.0..29.9 -> "Gemuk"
            else -> "Obesitas"
        }
        return BmiData(bmiValue = bmi, category = category)
    }
}