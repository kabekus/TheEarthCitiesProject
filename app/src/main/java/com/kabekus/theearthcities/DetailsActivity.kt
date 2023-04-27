package com.kabekus.theearthcities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kabekus.theearthcities.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selectCity = intent.getSerializableExtra("city") as City

        binding.cityNameTxt.text = selectCity.name
        binding.countryNameTxt.text =selectCity.countryName
        binding.imageView.setImageResource(selectCity.image)
    }
}