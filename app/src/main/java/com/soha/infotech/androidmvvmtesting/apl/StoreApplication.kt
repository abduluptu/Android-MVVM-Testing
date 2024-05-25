package com.soha.infotech.androidmvvmtesting.apl

import android.app.Application
import com.soha.infotech.androidmvvmtesting.api.ProductsAPI
import com.soha.infotech.androidmvvmtesting.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Step2: Create an application class
 */

class StoreApplication : Application() {

    lateinit var productsAPI: ProductsAPI
    lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .build()

        productsAPI = retrofit.create(ProductsAPI::class.java)
        productRepository = ProductRepository(productsAPI)
    }
}