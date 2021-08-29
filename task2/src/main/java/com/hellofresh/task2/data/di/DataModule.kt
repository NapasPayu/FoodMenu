package com.hellofresh.task2.data.di

import com.hellofresh.task2.BuildConfig
import com.hellofresh.task2.data.mapper.RecipeMapper
import com.hellofresh.task2.data.remote.RecipeService
import com.hellofresh.task2.data.repository.RecipeRepositoryImpl
import com.hellofresh.task2.domain.repository.RecipeRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    // mapper
    single { RecipeMapper() }

    // remote
    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(RecipeService::class.java) }

    // repository
    single<RecipeRepository> { RecipeRepositoryImpl(get(), get()) }
}
