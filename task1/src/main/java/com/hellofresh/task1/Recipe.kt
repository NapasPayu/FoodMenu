package com.hellofresh.task1

data class Recipe(
    val id: String,
    val title: String,
    val tags: Set<String>
)