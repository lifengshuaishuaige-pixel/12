package com.example.recipeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.entity.Recipe
import com.example.recipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private var currentRecipeId: Long = 0

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    data class UiState(
        val recipe: Recipe? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

    fun loadRecipe(recipeId: Long) {
        currentRecipeId = recipeId
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            recipeRepository.getRecipeById(recipeId).collect { recipe ->
                _uiState.value = _uiState.value.copy(
                    recipe = recipe,
                    isLoading = false
                )
            }
        }
    }

    fun toggleFavorite() {
        val currentRecipe = _uiState.value.recipe
        if (currentRecipe != null) {
            viewModelScope.launch {
                recipeRepository.toggleFavorite(currentRecipe.id, !currentRecipe.isFavorite)
            }
        }
    }
}