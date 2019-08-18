package net.bouzuya.sample1

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Sample1Application : Application() {
    // public for testing
    var homeViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel() as T
    }

    fun providesHomeViewModelFactory(): ViewModelProvider.Factory = homeViewModelFactory
}
