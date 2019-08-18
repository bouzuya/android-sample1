package net.bouzuya.sample1

import android.widget.TextView
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class BindingAdaptersKtTest {

    @Test
    fun setTextByCount() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val textView = TextView(context)
        textView.setTextByCount(null)
        assertThat(textView.text as? String, `is`(equalTo("")))

        textView.setTextByCount(100)
        assertThat(textView.text as? String, `is`(equalTo("100")))

        textView.setTextByCount(1_000)
        assertThat(textView.text as? String, `is`(equalTo("1,000")))

        textView.setTextByCount(1_000_000)
        assertThat(textView.text as? String, `is`(equalTo("1,000,000")))
    }
}