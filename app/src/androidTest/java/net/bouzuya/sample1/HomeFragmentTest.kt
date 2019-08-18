package net.bouzuya.sample1

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

class HomeFragmentTest {
    // TODO: mock viewModel

    @Test
    fun initialView() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_count_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_increment_button)).check(matches(isDisplayed()))
    }

    @Test
    fun initialValues() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(withText("Home")))
        onView(withId(R.id.home_count_text_view)).check(matches(withText("0")))
        onView(withId(R.id.home_increment_button)).check(matches(withText("+1")))
    }
}