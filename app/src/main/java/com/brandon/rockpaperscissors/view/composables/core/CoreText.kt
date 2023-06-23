package com.brandon.rockpaperscissors.view.composables.core

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DisplayLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displayLarge,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun DisplayMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displayMedium,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun DisplaySmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displaySmall,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun HeadlineLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun HeadlineMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun HeadlineSmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun TitleLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun TitleMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun TitleSmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleSmall,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun BodyLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun BodyMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun BodySmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun LabelLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelLarge,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun LabelMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun LabelSmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    maxLines: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = color,
        maxLines = maxLines
    )
}
