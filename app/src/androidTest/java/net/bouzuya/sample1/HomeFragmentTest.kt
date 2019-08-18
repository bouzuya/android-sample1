package net.bouzuya.sample1

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class HomeFragmentTest {
    lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = mock(HomeViewModel::class.java)

        val application =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Sample1Application
        application.homeViewModelFactory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
        }
    }

    @Test
    fun initialView() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_count_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.home_increment_button)).check(matches(isDisplayed()))
    }

    @Test
    fun initialValues() {
        `when`(viewModel.name).thenReturn("Home")
        `when`(viewModel.count).thenReturn(MutableLiveData(0))

        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_name_text_view)).check(matches(withText("Home")))
        onView(withId(R.id.home_count_text_view)).check(matches(withText("0")))
        onView(withId(R.id.home_increment_button)).check(matches(withText("+1")))
    }

    @Test
    fun clickIncrementButton() {
        launchFragmentInContainer<HomeFragment>()

        onView(withId(R.id.home_increment_button)).perform(click())

        verify(viewModel).increment()
    }
}
