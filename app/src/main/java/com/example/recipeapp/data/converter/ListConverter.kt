package com.example.recipeapp.data.converter

import androidx.room.TypeConverter
import com.example.recipeapp.data.entity.CookingStep
import com.example.recipeapp.data.entity.Ingredient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListConverter {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromIngredientList(value: String?): List<Ingredient> {
        return value?.let { json.decodeFromString<List<Ingredient>>(it) } ?: emptyList()
    }

    @TypeConverter
    fun toIngredientList(list: List<Ingredient>): String {
        return json.encodeToString(list)
    }

    @TypeConverter
    fun fromStepList(value: String?): List<CookingStep> {
        return value?.let { json.decodeFromString<List<CookingStep>>(it) } ?: emptyList()
    }

    @TypeConverter
    fun toStepList(list: List<CookingStep>): String {
        return json.encodeToString(list)
    }

    @TypeConverter
    fun fromStringList(value: String?): List<String> {
        return value?.let { json.decodeFromString<List<String>>(it) } ?: emptyList()
    }

    @TypeConverter
    fun toStringList(list: List<String>): String {
        return json.encodeToString(list)
    }
}