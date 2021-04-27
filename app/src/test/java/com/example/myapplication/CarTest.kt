package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CarTest {
    @Test
    fun testDriverName() {
        assertEquals(Car().getDriverName(), "Lee")
    }

    @Test
    fun testDriverAge() {
        assertEquals(Car().getDriverAge(), 30)
    }
}