package com.example.bmicalculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bmicalculator.databinding.FragmentOutputBinding
import com.example.bmicalculator.viewmodel.BmiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    private val viewModel: BmiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOutputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observasi LiveData dari ViewModel
        viewModel.bmiData.observe(viewLifecycleOwner) { bmiData ->
            binding.nilaiBmi.text = "Nilai BMI Anda: %.2f".format(bmiData.bmiValue)
            binding.kategoriBmi.text = "Kategori BMI: ${bmiData.category}"
        }

        // Tombol untuk membuka info developer
        binding.btnInfoDeveloper.setOnClickListener {
            val infoDeveloperFragment = InfoDeveloperFragment()
            infoDeveloperFragment.show(parentFragmentManager, "InfoDeveloper")
        }
    }
}
