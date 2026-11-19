package com.example.recipeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.recipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<Recipe>): List<Long>

    @Update
    suspend fun updateRecipe(recipe: Recipe): Int

    @Query("DELETE FROM recipes WHERE id = :id")
    suspend fun deleteRecipe(id: Long): Int

    @Query("SELECT * FROM recipes WHERE id = :id")
    fun getRecipeById(id: Long): Flow<Recipe?>

    @Query("SELECT * FROM recipes ORDER BY createdAt DESC")
    fun getAllRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE isFavorite = 1 ORDER BY createdAt DESC")
    fun getFavoriteRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY createdAt DESC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchRecipes(query: String): Flow<List<Recipe>>

    @Query("SELECT DISTINCT category FROM recipes ORDER BY category ASC")
    fun getAllCategories(): Flow<List<String>>

    @Query("UPDATE recipes SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun toggleFavorite(id: Long, isFavorite: Boolean): Int
}