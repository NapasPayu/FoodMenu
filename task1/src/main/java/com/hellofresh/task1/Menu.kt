package com.hellofresh.task1

class Menu(recipes: Set<Recipe>) {

    private enum class SelectionType(val max: Int) {
        DEFAULT(3),
        FAMILY(5)
    }

    private val selectableRecipes = recipes.map { it to false }.toMap().toMutableMap()
    private var selectionType = SelectionType.DEFAULT
    private var subscription: Subscription? = null

    private fun update(vararg recipes: Recipe, isSelected: Boolean) {
        val updateRecipes = recipes.map { it to isSelected }.toMap()
        selectableRecipes.putAll(updateRecipes)
    }

    fun getAllRecipes() = selectableRecipes.keys.toSet()

    fun getSelectedRecipes() = selectableRecipes.filterValues { it }.keys

    fun getSelectedRecipeCount() = selectableRecipes.count { it.value }

    fun select(vararg recipes: Recipe) {
        if (getSelectedRecipeCount() + recipes.size <= selectionType.max) {
            update(*recipes, isSelected = true)
        } else {
            throw IllegalArgumentException("Cannot select more than the maximum limit")
        }
    }

    fun unselect(vararg recipes: Recipe) {
        update(*recipes, isSelected = false)
    }

    fun getRecipesWithTag(tag: String) = selectableRecipes.filterKeys { tag in it.tags }.keys

    fun setSubscription(sub: Subscription) {
        subscription = sub
        selectionType = if (sub.isForFamily) {
            SelectionType.FAMILY
        } else {
            SelectionType.DEFAULT
        }
    }
}