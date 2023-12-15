package com.learning.exampleood.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.exampleood.data.network.MarsApi
import com.learning.exampleood.data.network.MarsPhoto
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    private lateinit var photoList: List<MarsPhoto>
    private var currentPhotoPosition = 0

    fun getMarsPhotos() {
        viewModelScope.launch {
            // TODO 1: Get data from the API and Update Livedata(s)
        }
    }

    fun nextImage() {
        if (currentPhotoPosition < photoList.size - 1) {
            currentPhotoPosition++
            // TODO 3: Update Livedata(s) with the right imageSource and ButtonState
        }

        if (currentPhotoPosition == photoList.lastIndex) {
            // TODO 3.1: Disable Next button if there are no more images to show
        }
    }

    fun previousImage() {
        if (currentPhotoPosition <= photoList.lastIndex && currentPhotoPosition != 0) {
            currentPhotoPosition--
            // TODO 3.2: Update LiveData(s) with the right imageSource and ButtonState
        }

        if (currentPhotoPosition == 0) {
            // TODO 3.3: Disable Previous button if we're at the start of the list
        }
    }
}