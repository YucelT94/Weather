package com.yucelt.base.component

abstract class BaseComponentViewObserver<ViewData> {
    abstract fun handleInput(viewData: ViewData?)
}