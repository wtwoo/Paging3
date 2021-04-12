package com.wtwoo.page3.ext

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.wtwoo.page3.Event

fun Context.toast(lifecycleOwner: LifecycleOwner, toastEvent: LiveData<Event<Int>>) {
    toastEvent.observe(lifecycleOwner, { event ->
        event.getContentIfNotHandled()?.let {
            toast(getString(it))
        }
    })
}


fun Context.toast(message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }


fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()


    }

