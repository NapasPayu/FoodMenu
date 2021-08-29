package com.hellofresh.task2.data.repository

import com.hellofresh.task2.data.mapper.RecipeMapper
import com.hellofresh.task2.data.remote.RecipeService
import com.hellofresh.task2.domain.model.Recipe
import com.hellofresh.task2.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val recipeMapper: RecipeMapper,
) : RecipeRepository {
    override suspend fun getRecipes(): Result<List<Recipe>> {
        return runCatching {
            recipeService.getRecipes().map(recipeMapper::mapFromEntity)
        }
    }
}