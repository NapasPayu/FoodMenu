package com.hellofresh.task2.data.mapper

import com.hellofresh.task2.data.model.RecipeEntity
import com.hellofresh.task2.domain.model.Recipe

class RecipeMapper : Mapper<RecipeEntity, Recipe> {

    override fun mapFromEntity(type: RecipeEntity): Recipe {
        return with(type) {
            Recipe(
                id = id,
                calories = calories,
                carbos = carbos,
                description = description,
                difficulty = difficulty,
                fats = fats,
                headline = headline,
                image = image,
                name = name,
                proteins = proteins,
                thumb = thumb,
                time = time
            )
        }
    }
}