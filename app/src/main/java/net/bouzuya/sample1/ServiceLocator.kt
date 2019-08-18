package net.bouzuya.sample1

import android.content.Context
import androidx.lifecycle.ViewModelProvider

object ServiceLocator {
    fun providesHomeViewModelFactory(context: Context): ViewModelProvider.Factory =
        (context.applicationContext as Sample1Application).providesHomeViewModelFactory()
}
