package com.example.recipeapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.recipeapp.ui.components.IngredientList
import com.example.recipeapp.ui.components.StepItem
import com.example.recipeapp.ui.viewmodel.RecipeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Composable
fun RecipeDetailScreen(
    recipeId: Long,
    onBackClick: () -> Unit
) {
    val viewModel: RecipeDetailViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (uiState.recipe != null) {
                        Text(
                            text = uiState.recipe!!.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                            contentDescription = "返回"
                        )
                    }
                },
                actions = {
                    if (uiState.recipe != null) {
                        IconButton(onClick = { viewModel.toggleFavorite() }) {
                            Icon(
                                imageVector = if (uiState.recipe!!.isFavorite)
                                    androidx.compose.material.icons.Icons.Filled.Favorite
                                else
                                    androidx.compose.material.icons.Icons.Outlined.Favorite,
                                contentDescription = if (uiState.recipe!!.isFavorite) "取消收藏" else "收藏",
                                tint = if (uiState.recipe!!.isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        if (uiState.isLoading) {
            androidx.compose.material3.CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        } else if (uiState.recipe != null) {
            val recipe = uiState.recipe!!
            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Header with image
                    item {
                        if (!recipe.imageUrl.isNullOrEmpty()) {
                            AsyncImage(
                                model = recipe.imageUrl,
                                contentDescription = recipe.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(240.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }

                    // Title and meta
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = recipe.title,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )

                            androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.padding(8.dp))

                            // Meta info row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                MetaItem("⏱️", "${recipe.prepTimeMinutes + recipe.cookTimeMinutes}分钟")
                                MetaItem("👥", "${recipe.servings}人份")
                                MetaItem("⭐", recipe.difficulty.displayName)
                                MetaItem("🔥", "${recipe.caloriesPerServing ?: 0}大卡/份")
                            }
                        }
                    }

                    // Description
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            androidx.compose.foundation.layout.Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = "📝 菜品介绍",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                                )
                                androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.padding(8.dp))
                                Text(
                                    text = recipe.description,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    // Ingredients
                    item {
                        IngredientList(ingredients = recipe.ingredients, modifier = Modifier.padding(horizontal = 16.dp))
                    }

                    // Steps
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "👨‍🍳 制作步骤",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                        }
                    }

                    items(recipe.steps) { step ->
                        StepItem(step = step, modifier = Modifier.padding(horizontal = 16.dp))
                    }

                    item {
                        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun MetaItem(icon: String, text: String) {
    androidx.compose.foundation.layout.Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = icon, fontSize = 16.sp)
        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.width(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}