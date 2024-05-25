package com.soha.infotech.androidmvvmtesting.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soha.infotech.androidmvvmtesting.repository.ProductRepository

/**
 * Step6.1: Create a ViewModelFactory class
 */

class MainViewModelFactory(private val productRepository: ProductRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }
}