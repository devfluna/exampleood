package com.learning.exampleood

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.learning.exampleood.databinding.ActivityMainBinding
import com.learning.exampleood.ui.ButtonState
import com.learning.exampleood.ui.MarsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MarsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMarsPhotos()

        viewModel.marsPhotoUrl.observe(this, ::updateMarsImage)
        viewModel.buttonState.observe(this, ::updateButtons)

        binding.btnNext.setOnClickListener { viewModel.nextImage() }
        binding.btnPrevious.setOnClickListener { viewModel.previousImage() }
    }

    private fun updateMarsImage(url: String) {
        Glide.with(this).load(url).into(binding.ivMarsPhoto)
    }

    private fun updateButtons(state: ButtonState) {
        with(binding) {
            when (state) {
                ButtonState.LEFT_DISABLED -> {
                    btnPrevious.isEnabled = false
                    btnPrevious.visibility = View.INVISIBLE
                }
                ButtonState.BOTH_ENABLED -> {
                    btnPrevious.isEnabled = true
                    btnPrevious.visibility = View.VISIBLE
                    btnNext.isEnabled = true
                    btnNext.visibility = View.VISIBLE
                }
                ButtonState.RIGHT_DISABLED -> {
                    btnNext.isEnabled = true
                    btnNext.visibility = View.INVISIBLE
                }
            }
        }
    }
}