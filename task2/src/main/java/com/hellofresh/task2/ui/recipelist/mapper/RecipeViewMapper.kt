package com.hellofresh.task2.ui.recipelist.mapper

import com.hellofresh.task2.domain.model.Recipe
import com.hellofresh.task2.ui.common.mapper.ViewMapper
import com.hellofresh.task2.ui.recipelist.model.RecipeView

class RecipeViewMapper : ViewMapper<Recipe, RecipeView> {

    override fun mapToView(type: Recipe): RecipeView {
        return with(type) {
            RecipeView(
                id = id,
                imageUrl = image,
                title = name,
                headline = headline
            )
        }
    }
}