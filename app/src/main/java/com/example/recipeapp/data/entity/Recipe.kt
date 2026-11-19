package com.example.recipeapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.recipeapp.data.converter.ListConverter
import kotlinx.serialization.Serializable

@Entity(tableName = "recipes")
@Serializable
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val imageUrl: String?,
    val category: String,
    val cuisine: String,
    val difficulty: Difficulty,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val caloriesPerServing: Int?,
    @TypeConverters(ListConverter::class) val ingredients: List<Ingredient>,
    @TypeConverters(ListConverter::class) val steps: List<CookingStep>,
    @TypeConverters(ListConverter::class) val tags: List<String>,
    val isFavorite: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

@Serializable
enum class Difficulty(val displayName: String) {
    EASY("简单"),
    MEDIUM("中等"),
    HARD("困难")
}

@Serializable
data class Ingredient(
    val name: String,
    val amount: String,
    val unit: String,
    val notes: String? = null
)

@Serializable
data class CookingStep(
    val stepNumber: Int,
    val instruction: String,
    val imageUrl: String? = null,
    val durationMinutes: Int? = null,
    val tips: String? = null
)