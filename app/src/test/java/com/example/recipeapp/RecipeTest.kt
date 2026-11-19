package com.example.recipeapp

import com.example.recipeapp.data.entity.CookingStep
import com.example.recipeapp.data.entity.Difficulty
import com.example.recipeapp.data.entity.Ingredient
import com.example.recipeapp.data.entity.Recipe
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class RecipeTest {

    @Test
    fun testRecipeSerialization() {
        val recipe = Recipe(
            title = "测试食谱",
            description = "测试描述",
            imageUrl = "https://example.com/image.jpg",
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.MEDIUM,
            prepTimeMinutes = 10,
            cookTimeMinutes = 15,
            servings = 2,
            caloriesPerServing = 200,
            ingredients = listOf(
                Ingredient("测试配料", "100", "克", "备注")
            ),
            steps = listOf(
                CookingStep(1, "第一步", null, 5, "小贴士"),
                CookingStep(2, "第二步", "https://example.com/step2.jpg", 10, null)
            ),
            tags = listOf("测试", "快手菜"),
            isFavorite = true
        )

        val json = Json { ignoreUnknownKeys = true }
        val jsonString = json.encodeToString(recipe)
        val decoded = json.decodeFromString<Recipe>(jsonString)

        assertEquals(recipe.title, decoded.title)
        assertEquals(recipe.difficulty, decoded.difficulty)
        assertEquals(recipe.ingredients.size, decoded.ingredients.size)
        assertEquals(recipe.steps.size, decoded.steps.size)
        assertEquals(recipe.tags, decoded.tags)
        assertEquals(recipe.isFavorite, decoded.isFavorite)
    }

    @Test
    fun testDifficultyDisplayNames() {
        assertEquals("简单", Difficulty.EASY.displayName)
        assertEquals("中等", Difficulty.MEDIUM.displayName)
        assertEquals("困难", Difficulty.HARD.displayName)
    }

    @Test
    fun testSampleRecipesNotEmpty() {
        val recipes = com.example.recipeapp.data.database.SampleRecipes.getSampleRecipes()
        assertNotNull(recipes)
        assertEquals(8, recipes.size)
        
        // 验证每个食谱都有基本信息
        recipes.forEach { recipe ->
            assertNotNull(recipe.title)
            assertNotNull(recipe.description)
            assertNotNull(recipe.category)
            assertNotNull(recipe.cuisine)
            assertNotNull(recipe.ingredients)
            assertNotNull(recipe.steps)
            assertNotNull(recipe.tags)
            assert(recipe.ingredients.isNotEmpty()) { "食谱 ${recipe.title} 缺少配料" }
            assert(recipe.steps.isNotEmpty()) { "食谱 ${recipe.title} 缺少步骤" }
        }
    }
}