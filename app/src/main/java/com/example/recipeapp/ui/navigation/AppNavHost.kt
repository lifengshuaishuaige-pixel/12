package com.example.recipeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.ui.screen.RecipeDetailScreen
import com.example.recipeapp.ui.screen.RecipeListScreen
import com.example.recipeapp.ui.viewmodel.RecipeDetailViewModel
import com.example.recipeapp.ui.viewmodel.RecipeListViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "list") {
        composable("list") {
            RecipeListScreen(
                onRecipeClick = { recipeId ->
                    navController.navigate("detail/$recipeId")
                },
                onSearchClick = { /* TODO: Search screen */ },
                onFavoriteClick = { /* TODO: Favorites screen */ }
            )
        }
        composable(
            route = "detail/{recipeId}",
            arguments = listOf(androidx.navigation.navArgument("recipeId") { type = androidx.navigation.NavType.LongType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.getLong("recipeId")
            val viewModel: RecipeDetailViewModel = hiltViewModel()
            viewModel.loadRecipe(recipeId)

            RecipeDetailScreen(
                recipeId = recipeId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun RememberNavController(): NavHostController = rememberNavController()