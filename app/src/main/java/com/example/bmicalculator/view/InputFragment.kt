package com.example.bmicalculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bmicalculator.R
import com.example.bmicalculator.databinding.FragmentInputBinding
import com.example.bmicalculator.viewmodel.BmiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding
    private val viewModel: BmiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHitungBmi.setOnClickListener {
            val weight = binding.edtBeratBadan.text.toString()
            val height = binding.edtTinggiBadan.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                val weight = weight.toDoubleOrNull()
                val height = height.toDoubleOrNull()

                if (weight != null && height != null && height > 0) {
                    viewModel.calculateBmi(weight, height)

                    // Navigasi ke OutputFragment
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, OutputFragment())
                        .addToBackStack(null)
                        .commit()

                } else {
                    Toast.makeText(requireContext(), "Masukkan nilai berat dan tinggi yang valid", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Isi berat dan tinggi badan terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
