package com.hellofresh.task2.ui.common.mapper

interface ViewMapper<D, V> {
    fun mapToView(type: D): V
}