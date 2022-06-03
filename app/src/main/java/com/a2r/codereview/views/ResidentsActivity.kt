package com.a2r.codereview.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a2r.codereview.R
import com.a2r.codereview.databinding.ActivityResidentsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResidentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResidentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //used viewBinding and switched to Mvvm arch
        binding = ActivityResidentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container, FragmentResidents()).commit()
    }
}