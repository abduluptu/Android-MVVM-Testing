package com.soha.infotech.androidmvvmtesting

import java.io.InputStreamReader

/**
 * Step4: To read json file
 */

object Helper {

    fun readFileResource(filename: String): String {
        val inputStream = Helper::class.java.getResourceAsStream(filename)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream, "UTF-8")
        reader.readLines().forEach {
            builder.append(it)
        }
        return builder.toString()
    }
}