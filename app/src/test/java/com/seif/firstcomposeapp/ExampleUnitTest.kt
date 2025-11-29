package com.seif.firstcomposeapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val actual = sum(2, 2)
        assertEquals(4, actual)
    }
}

fun sum(num1:Int, num2:Int): Int{
    return num1 + num2
}