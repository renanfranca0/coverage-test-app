package com.example.coveragetestapp.testutils

import androidx.annotation.IdRes
import androidx.annotation.VisibleForTesting
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
internal fun click(@IdRes id: Int) {
    Espresso.onView(ViewMatchers.withId(id)).perform(ViewActions.click())
}