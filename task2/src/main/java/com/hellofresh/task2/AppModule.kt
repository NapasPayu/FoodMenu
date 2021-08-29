package com.hellofresh.task2

import com.hellofresh.task2.data.di.dataModule
import com.hellofresh.task2.domain.di.domainModule
import com.hellofresh.task2.ui.recipelist.di.featureRecipeListModule

val appModule = listOf(
    dataModule,
    domainModule,
    featureRecipeListModule
)