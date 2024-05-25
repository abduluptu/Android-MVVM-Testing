package com.soha.infotech.androidmvvmtesting.repository

import com.soha.infotech.androidmvvmtesting.api.ProductsAPI
import com.soha.infotech.androidmvvmtesting.modes.ProductListItem
import com.soha.infotech.androidmvvmtesting.utils.NetworkResult

/**
 * Step5: Create a Repository class
 */

class ProductRepository(private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}