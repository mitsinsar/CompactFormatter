package com.mitsinsar.peracompactdecimalformat.utils

import android.util.Log

actual object PeraLogger {

    actual fun log(tag: String, message: String) {
        Log.e(tag, message)
    }
}
