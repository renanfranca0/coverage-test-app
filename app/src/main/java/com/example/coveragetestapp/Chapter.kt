package com.example.coveragetestapp

class Chapter {

    fun helloWorld(): String = "Hello ${world()}!"

    fun print(s: String) = "Hello $s!"

    private inline fun world() = "world"
}