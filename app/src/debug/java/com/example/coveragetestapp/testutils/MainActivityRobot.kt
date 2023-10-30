package com.example.coveragetestapp.testutils

import android.app.Activity
import androidx.annotation.VisibleForTesting
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.example.coveragetestapp.MainActivity
import com.example.coveragetestapp.R

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
internal fun launchMainActivity(
    func: MainActivityRobot.Action.() -> Unit
): MainActivityRobot.Action {
    launchActivity<MainActivity>()
    return MainActivityRobot().Action().apply(func)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
internal class MainActivityRobot {

    inner class Action {

        fun clickIncrementButton() {
            click(R.id.incrementButton)
        }

        fun clickDecrementButton() {
            click(R.id.decrementButton)
        }

        fun clickNavigateToSecondActivity() {
            click(R.id.navigateToSecond)
        }

        fun clickNavigateToPicPay() {
            click(R.id.navigateToPicPayButton)
        }

        infix fun assert(func: Check.() -> Unit) = Check().apply(func)
    }

    inner class Check {
        fun checkCounterIs(expected: String) {
            Espresso
                .onView(ViewMatchers.withId(R.id.counterTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText(expected)))
        }

        fun checkSentIntentToActivity(
            activityClass: Class<out Activity>,
        ) {
            Intents.intended(IntentMatchers.hasComponent(activityClass.name))
        }

        fun checkOpenPicPayApp() {
            Intents.intended(
                IntentMatchers.toPackage("com.picpay.debug")
            )
        }
    }
}