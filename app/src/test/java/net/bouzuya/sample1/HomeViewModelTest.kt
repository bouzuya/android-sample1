package net.bouzuya.sample1

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun defaultValues() {
        val viewModel = HomeViewModel()
        assertThat(viewModel.name, `is`("Home"))
        assertThat(viewModel.count.value, `is`(0))
    }

    @Test
    fun increment() {
        val viewModel = HomeViewModel()
        viewModel.increment()
        assertThat(viewModel.count.value, `is`(1))
    }
}
