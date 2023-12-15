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

        // TODO 2: Have the ViewModel get Mars Photos

        // TODO 2.1: Observe changes from the LiveData and update the ImageView [RUN APP WHEN FINISHED]

        // TODO 4: Observe changes from the LiveData and update the buttons

        binding.btnNext.setOnClickListener {
            // TODO 4.1: Call ViewModel for the next image
        }
        binding.btnPrevious.setOnClickListener {
            // TODO 4.2: Call ViewModel for the previous image
        }
    }

    private fun updateMarsImage(url: String) {
        Glide.with(this).load(url).into(binding.ivMarsPhoto)
    }

    private fun updateButtons(state: ButtonState) {
        // TODO 4.3: Update button Visibility and IsEnabled based on state [RUN THE APP WHEN FINISHED]
    }
}