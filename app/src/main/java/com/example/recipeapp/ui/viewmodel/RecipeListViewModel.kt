package com.example.recipeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _recipes = MutableStateFlow<List<com.example.recipeapp.data.entity.Recipe>>(emptyList())
    val recipes: StateFlow<List<com.example.recipeapp.data.entity.Recipe>> = _recipes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadAllRecipes()
    }

    fun loadAllRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            recipeRepository.getAllRecipes().collect { recipeList ->
                _recipes.value = recipeList
                _isLoading.value = false
            }
        }
    }

    fun loadFavoriteRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            recipeRepository.getFavoriteRecipes().collect { recipeList ->
                _recipes.value = recipeList
                _isLoading.value = false
            }
        }
    }

    fun loadRecipesByCategory(category: String) {
        viewModelScope.launch {
            _isLoading.value = true
            recipeRepository.getRecipesByCategory(category).collect { recipeList ->
                _recipes.value = recipeList
                _isLoading.value = false
            }
        }
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            if (query.isBlank()) {
                recipeRepository.getAllRecipes().collect { recipeList ->
                    _recipes.value = recipeList
                    _isLoading.value = false
                }
            } else {
                recipeRepository.searchRecipes(query).collect { recipeList ->
                    _recipes.value = recipeList
                    _isLoading.value = false
                }
            }
        }
    }
}