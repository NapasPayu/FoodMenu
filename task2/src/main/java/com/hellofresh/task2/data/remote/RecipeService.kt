package com.hellofresh.task2.data.remote

import com.hellofresh.task2.data.model.RecipeEntity
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes.json")
    suspend fun getRecipes(): List<RecipeEntity>
}