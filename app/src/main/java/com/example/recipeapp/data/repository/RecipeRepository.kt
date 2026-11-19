package com.example.recipeapp.data.repository

import com.example.recipeapp.data.dao.RecipeDao
import com.example.recipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {
    fun getAllRecipes(): Flow<List<Recipe>> = recipeDao.getAllRecipes()

    fun getFavoriteRecipes(): Flow<List<Recipe>> = recipeDao.getFavoriteRecipes()

    fun getRecipesByCategory(category: String): Flow<List<Recipe>> = recipeDao.getRecipesByCategory(category)

    fun searchRecipes(query: String): Flow<List<Recipe>> = recipeDao.searchRecipes(query)

    fun getRecipeById(id: Long): Flow<Recipe?> = recipeDao.getRecipeById(id)

    fun getAllCategories(): Flow<List<String>> = recipeDao.getAllCategories()

    suspend fun insertRecipe(recipe: Recipe): Long = recipeDao.insertRecipe(recipe)

    suspend fun insertRecipes(recipes: List<Recipe>): List<Long> = recipeDao.insertRecipes(recipes)

    suspend fun updateRecipe(recipe: Recipe): Int = recipeDao.updateRecipe(recipe)

    suspend fun deleteRecipe(id: Long): Int = recipeDao.deleteRecipe(id)

    suspend fun toggleFavorite(id: Long, isFavorite: Boolean): Int = recipeDao.toggleFavorite(id, isFavorite)
}