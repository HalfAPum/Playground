package com.example.pagingsample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pagingsample.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
): ViewModel() {

    fun locationsFlow() = rickAndMortyRepository.getLocationsPagingData()

}