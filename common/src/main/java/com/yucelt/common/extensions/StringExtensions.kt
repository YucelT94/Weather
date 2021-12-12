package com.yucelt.common.extensions

fun String.cleanHref() = this.replace("{?dtg}", "")