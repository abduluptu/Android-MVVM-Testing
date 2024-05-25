package com.soha.infotech.androidmvvmtesting.api

import com.soha.infotech.androidmvvmtesting.modes.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * Step4: Create an Api Interface
 */

interface ProductsAPI {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductListItem>>
}