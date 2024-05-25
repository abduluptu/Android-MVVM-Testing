package com.soha.infotech.androidmvvmtesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soha.infotech.androidmvvmtesting.modes.ProductListItem
import com.soha.infotech.androidmvvmtesting.repository.ProductRepository
import com.soha.infotech.androidmvvmtesting.utils.NetworkResult
import kotlinx.coroutines.launch

/**
 * Step6: Create a ViewModel class
 */

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<NetworkResult<List<ProductListItem>>>()
    val products: LiveData<NetworkResult<List<ProductListItem>>>
        get() = _products

    fun getProducts() {
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.postValue(result)
        }
    }
}