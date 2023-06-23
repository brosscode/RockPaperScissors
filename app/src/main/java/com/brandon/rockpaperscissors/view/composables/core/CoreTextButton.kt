package com.brandon.rockpaperscissors.view.composables.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import com.brandon.rockpaperscissors.view.composables.core.CoreButtonText.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.brandon.rockpaperscissors.view.composables.theme.dimens
import com.brandon.rockpaperscissors.view.composables.theme.staticDimens

@Composable
fun CoreTextButton(
    modifier: Modifier = Modifier,
    coreButtonText: CoreButtonText = BODY_M,
    color: Color = MaterialTheme.colorScheme.primary,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.padding(MaterialTheme.dimens.grid1x),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        onClick = onClick
    ) {
        coreButtonText.Compose(text)
    }
}

enum class CoreButtonText {
    LABEL_S,
    LABEL_M,
    LABEL_L,
    BODY_S,
    BODY_M,
    BODY_L,
    TITLE_S,
    TITLE_M,
    TITLE_L,
    HEADLINE_S,
    HEADLINE_M,
    HEADLINE_L,
    DISPLAY_S,
    DISPLAY_M,
    DISPLAY_L;

    @Composable
    fun Compose(
        text: String,
    ) = when(this) {
        LABEL_S -> LabelSmallText(text = text)
        LABEL_M -> LabelMediumText(text = text)
        LABEL_L -> LabelLargeText(text = text)
        BODY_S -> BodySmallText(text = text)
        BODY_M -> BodyMediumText(text = text)
        BODY_L -> BodyLargeText(text = text)
        TITLE_S -> TitleSmallText(text = text)
        TITLE_M -> TitleMediumText(text = text)
        TITLE_L -> TitleLargeText(text = text)
        HEADLINE_S -> HeadlineSmallText(text = text)
        HEADLINE_M -> HeadlineMediumText(text = text)
        HEADLINE_L -> HeadlineLargeText(text = text)
        DISPLAY_S -> DisplaySmallText(text = text)
        DISPLAY_M -> DisplayMediumText(text = text)
        DISPLAY_L -> DisplayLargeText(text = text)
    }
}
