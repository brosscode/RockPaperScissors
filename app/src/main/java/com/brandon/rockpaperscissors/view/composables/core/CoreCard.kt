package com.brandon.rockpaperscissors.view.composables.core

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.brandon.rockpaperscissors.view.composables.theme.dimens
import com.brandon.rockpaperscissors.view.composables.theme.staticDimens

@Composable
fun CoreCard(
    modifier: Modifier = Modifier,
    cardShape: CoreCardShape = CoreCardShape.ROUNDED_RECTANGLE,
    backgroundColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.padding(MaterialTheme.dimens.grid2x),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = cardShape.toShape(),
        elevation = CardDefaults.cardElevation(MaterialTheme.staticDimens.grid2x)
    ) {
        content()
    }
}

enum class CoreCardShape {
    CIRCLE,
    ROUNDED_RECTANGLE,
    SQUARE;

    fun toShape() = when (this) {
        CIRCLE -> CircleShape
        ROUNDED_RECTANGLE -> RoundedCornerShape(MaterialTheme.staticDimens.grid4x)
        SQUARE -> RectangleShape
    }
}
