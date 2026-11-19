package com.example.recipeapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipeapp.data.entity.CookingStep

@Composable
fun StepItem(
    step: CookingStep,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Step header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Step number badge
                androidx.compose.material3.Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = step.stepNumber.toString(),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Duration if available
                step.durationMinutes?.let { duration ->
                    Text(
                        text = "⏱️ ${duration}分钟",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Step instruction
            Text(
                text = step.instruction,
                style = MaterialTheme.typography.bodyMedium
            )

            // Step image if available
            if (!step.imageUrl.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                AsyncImage(
                    model = step.imageUrl,
                    contentDescription = "步骤${step.stepNumber}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
            }

            // Tips if available
            if (!step.tips.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Surface(
                    color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "💡 ${step.tips}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}