package com.hellofresh.task2.ui.recipelist.di

import com.hellofresh.task2.ui.recipelist.RecipeListViewModel
import com.hellofresh.task2.ui.recipelist.mapper.RecipeViewMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureRecipeListModule = module {
    single { RecipeViewMapper() }
    viewModel { RecipeListViewModel(get(), get()) }
}