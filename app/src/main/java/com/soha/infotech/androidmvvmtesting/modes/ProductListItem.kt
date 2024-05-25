package com.soha.infotech.androidmvvmtesting.modes

/**
 * Step3: Create a  model class
 */

data class ProductListItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)
