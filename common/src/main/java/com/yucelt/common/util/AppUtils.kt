package com.yucelt.common.util

import android.content.Context
import java.io.File

fun Context.clearData() {
    val files = this.getDir("tmp", Context.MODE_PRIVATE)
    files.parentFile?.delete(false)
}

private fun File.delete(deleteDir: Boolean) {
    if (this.isDirectory) {
        val files = this.listFiles()
        if (files != null) {
            for (f in files) {
                f.delete(true)
            }
        }
        if (deleteDir) {
            this.delete()
        }
    } else {
        this.delete()
    }
}
