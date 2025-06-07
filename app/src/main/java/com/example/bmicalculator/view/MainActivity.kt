// hari tanggal pengerjaan : 29 Mei 2025
// nim                     : 10122362
// nama lengkap            : Louis Jonathan Susanto Putra
// kelas                   : PA 4

package com.example.bmicalculator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R
import com.example.bmicalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, InputFragment())
            .commit()
    }
}