package net.bouzuya.sample1

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test

class HomeFragmentTest {

    @Test
    fun initialView() {
        // TODO: mock viewModel
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_count_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_increment_button)).check(matches(isDisplayed()))
    }
}