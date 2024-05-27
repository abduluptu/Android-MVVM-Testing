package com.soha.infotech.androidmvvmtesting.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.soha.infotech.androidmvvmtesting.getOrAwaitValue
import com.soha.infotech.androidmvvmtesting.repository.ProductRepository
import com.soha.infotech.androidmvvmtesting.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

// Step1: Test View Model

class MainViewModelTest {

    // This dispatcher is used to control Coroutines behavior in tests
    private val testDispatcher = StandardTestDispatcher()

    // This rule ensures that LiveData operations happen immediately on the same thread
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        // Initialize mock/fake object
        MockitoAnnotations.openMocks(this)
        // Set the testDispatcher as the default CoroutineDispatcher for testing
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_GetProducts() = runTest {
        // Define behaviour to return empty list
        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))

        // pass mock object as repository  inside MainViewModel
        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        assertEquals(0, result.data!!.size)
    }

    @Test
    fun test_GetProduct_expectedError() = runTest {
        Mockito.`when`(repository.getProducts())
            .thenReturn(NetworkResult.Error("Something Went Wrong"))

        val sut = MainViewModel(repository)
        sut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.products.getOrAwaitValue()
        assertEquals(true, result is NetworkResult.Error)
        assertEquals("Something Went Wrong", result.message)
    }

    @After
    fun tearDown() {
        // reset Coroutines back to the main Dispatcher
        Dispatchers.resetMain()
    }
}