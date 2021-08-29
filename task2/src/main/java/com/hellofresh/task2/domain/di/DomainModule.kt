package com.hellofresh.task2.domain.di

import com.hellofresh.task2.domain.usecase.GetRecipesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetRecipesUseCase(get()) }
}