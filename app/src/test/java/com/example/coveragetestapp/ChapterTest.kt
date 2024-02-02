package com.example.coveragetestapp

import org.junit.Assert.*
import org.junit.Test

class ChapterTest {

    private val chapter = Chapter()

    @Test
    fun `helloWorld function should show correct string`() {
        // Given
        val expected = "Hello world!"

        // When
        val result = chapter.helloWorld()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `print function should show parameter string`() {
        // Given
        val expected = "Hello world!"

        // When
        val result = chapter.print("world")

        // Then
        assertEquals(expected, result)
    }
}