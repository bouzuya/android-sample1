package net.bouzuya.sample1

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:count")
fun TextView.setTextByCount(count: Int?) {
    text = count?.let { String.format("%,d", it) } ?: ""
}
