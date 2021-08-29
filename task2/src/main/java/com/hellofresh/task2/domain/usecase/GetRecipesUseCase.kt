package com.hellofresh.task2.domain.usecase

import com.hellofresh.task2.domain.model.Recipe
import com.hellofresh.task2.domain.repository.RecipeRepository

class GetRecipesUseCase(private val recipeRepository: RecipeRepository) {
    suspend operator fun invoke(): Result<List<Recipe>> = recipeRepository.getRecipes()
}