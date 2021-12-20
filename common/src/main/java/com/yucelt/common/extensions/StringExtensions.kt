package com.yucelt.common.extensions

fun String.cleanHref() = this.replace("{?dtg}", "")

fun String.capitalizeFirstLetter() = this.split(" ").joinToString(" ") { it.capitalize() }.trimEnd()
