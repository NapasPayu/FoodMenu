package com.hellofresh.task1

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MenuTest {

    private val recipe1 = Recipe("1", "recipe1", setOf("hot"))
    private val recipe2 = Recipe("2", "recipe2", setOf("quick"))
    private val recipe3 = Recipe("3", "recipe3", setOf("low-calories"))
    private val recipe4 = Recipe("4", "recipe4", setOf("hot", "quick"))
    private val recipe5 = Recipe("5", "recipe5", setOf("hot", "quick", "low-calories"))

    private lateinit var menu: Menu

    @Before
    fun setup() {
        menu = Menu(setOf(recipe1, recipe2, recipe3, recipe4, recipe5))
    }

    @Test
    fun `get all recipes`() {
        val expectedResult = setOf(recipe1, recipe2, recipe3, recipe4, recipe5)

        assertEquals(expectedResult, menu.getAllRecipes())
    }

    //---------- Selecting recipes in the menu ------------------
    @Test
    fun `mark a single recipe as selected`() {
        val expectedResult = setOf(recipe1)

        menu.select(recipe1)

        assertEquals(expectedResult, menu.getSelectedRecipes())
    }

    @Test
    fun `mark multiple recipes as selected`() {
        val expectedResult = setOf(recipe1, recipe2, recipe3)

        menu.select(recipe1, recipe2, recipe3)

        assertEquals(expectedResult, menu.getSelectedRecipes())
    }

    @Test
    fun `ask the menu how many recipes have been selected`() {
        val expectedResult = 3

        menu.select(recipe1, recipe2, recipe3)

        assertEquals(expectedResult, menu.getSelectedRecipeCount())
    }

    //---------- Unselecting recipes in the menu ------------------
    @Test
    fun `unselect a single selected recipe`() {
        val expectedResult = setOf(recipe1)

        menu.select(recipe1, recipe2)
        menu.unselect(recipe2)

        assertEquals(expectedResult, menu.getSelectedRecipes())
    }

    @Test
    fun `unselect multiple selected recipes`() {
        val expectedResult = setOf(recipe1)

        menu.select(recipe1, recipe2, recipe3)
        menu.unselect(recipe2, recipe3)

        assertEquals(expectedResult, menu.getSelectedRecipes())
    }

    //---------- Accessing recipes in the menu ------------------
    @Test
    fun `request a list of selected recipes`() {
        val expectedResult = emptySet<Recipe>()

        assertEquals(expectedResult, menu.getSelectedRecipes())
    }

    @Test
    fun `request a list of recipes which have a certain tag`() {
        val expectedResult = setOf(recipe1, recipe4, recipe5)

        assertEquals(expectedResult, menu.getRecipesWithTag("hot"))
    }

    //---------- Restricting the behavior ----------------------
    @Test(expected = IllegalArgumentException::class)
    fun `select more than 3 recipes`() {
        menu.select(recipe1, recipe2, recipe3, recipe4)
    }

    //----- Modifying the behavior based on subscription type ----
    @Test
    fun `select up to 5 recipes if the subscription is for a family`() {
        val familySubscription = Subscription("1", "Mon", true)
        val expectedResult = 5

        menu.setSubscription(familySubscription)
        menu.select(recipe1, recipe2, recipe3, recipe4, recipe5)

        assertEquals(expectedResult, menu.getSelectedRecipeCount())
    }

}