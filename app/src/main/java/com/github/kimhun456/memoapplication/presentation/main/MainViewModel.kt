package com.github.kimhun456.memoapplication.presentation.main

import androidx.lifecycle.ViewModel
import com.github.kimhun456.memoapplication.domain.interactor.CreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }
}