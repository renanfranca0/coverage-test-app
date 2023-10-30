package com.example.coveragetestapp.testutils

import androidx.test.espresso.intent.Intents
import org.junit.rules.ExternalResource

open class IntentsTestRule : ExternalResource() {
    override fun before() {
        super.before()
        Intents.init()
    }

    override fun after() {
        super.after()
        Intents.release()
    }
}