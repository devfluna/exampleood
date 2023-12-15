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

    private val _marsPhotoUrl = MutableLiveData<String>()
    val marsPhotoUrl: LiveData<String> = _marsPhotoUrl

    private val _buttonState = MutableLiveData<ButtonState>()
    val buttonState: LiveData<ButtonState> = _buttonState

    fun getMarsPhotos() {
        viewModelScope.launch {
            photoList = MarsApi.retrofitService.getPhotos()
            _marsPhotoUrl.postValue(photoList.first().imageSource)
            _buttonState.postValue(ButtonState.LEFT_DISABLED)
        }
    }

    fun nextImage() {
        if (currentPhotoPosition < photoList.size - 1) {
            currentPhotoPosition++
            _marsPhotoUrl.postValue(photoList[currentPhotoPosition].imageSource)
            _buttonState.postValue(ButtonState.BOTH_ENABLED)
        }

        if (currentPhotoPosition == photoList.lastIndex)
            _buttonState.postValue(ButtonState.RIGHT_DISABLED)
    }

    fun previousImage() {
        if (currentPhotoPosition <= photoList.lastIndex && currentPhotoPosition != 0) {
            currentPhotoPosition--
            _marsPhotoUrl.postValue(photoList[currentPhotoPosition].imageSource)
            _buttonState.postValue(ButtonState.BOTH_ENABLED)
        }

        if (currentPhotoPosition == 0) _buttonState.postValue(ButtonState.LEFT_DISABLED)
    }
}