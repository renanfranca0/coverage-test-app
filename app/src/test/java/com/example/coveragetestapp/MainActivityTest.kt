package com.example.coveragetestapp

import com.example.coveragetestapp.testutils.IntentsTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.coveragetestapp.testutils.launchMainActivity

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule()

    @Test
    fun `should show zero in counter when open MainActivity`() {
        launchMainActivity {
        } assert {
            checkCounterIs("0")
        }
    }

    @Test
    fun whenClickingIncrementButton_ShouldShow1InCounter() {
        launchMainActivity {
            clickIncrementButton()
        } assert {
            checkCounterIs("1")
        }
    }

    @Test
    fun whenClickingDecrementButton_ShouldShowNegative1InCounter() {
        launchMainActivity {
            clickDecrementButton()
        } assert {
            checkCounterIs("-1")
        }
    }

    @Test
    fun whenClickingNavigateToSecondButton_ShouldNavigateToSecondActivity() {
        launchMainActivity {
            clickNavigateToSecondActivity()
        } assert {
            checkSentIntentToActivity(SecondActivity::class.java)
        }
    }
}