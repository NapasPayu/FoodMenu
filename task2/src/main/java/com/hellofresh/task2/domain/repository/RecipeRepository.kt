package com.hellofresh.task2.domain.repository

import com.hellofresh.task2.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): Result<List<Recipe>>
}