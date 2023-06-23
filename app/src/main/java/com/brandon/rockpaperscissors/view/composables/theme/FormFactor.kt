package com.brandon.rockpaperscissors.view.composables.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalFormFactor: ProvidableCompositionLocal<FormFactor> =
    compositionLocalOf { FormFactor.WIDE_DISPLAY }

enum class FormFactor {
    THIN_DISPLAY,
    WIDE_DISPLAY,
    EXTRA_WIDE_DISPLAY;

    val isThin: Boolean
        get() = this == THIN_DISPLAY

    val isWide: Boolean
        get() = this == WIDE_DISPLAY

    val isExtraWide: Boolean
        get() = this == EXTRA_WIDE_DISPLAY

    val isWideOrExtraWide: Boolean
        get() = this == WIDE_DISPLAY || this == EXTRA_WIDE_DISPLAY

    companion object {
        fun getFactor(screenWidthPixels: Int) = when {
            screenWidthPixels < SMALL_PHONE_SCREEN_WIDTH_PIXELS -> THIN_DISPLAY
            screenWidthPixels < LARGE_PHONE_SCREEN_WIDTH_PIXELS -> WIDE_DISPLAY
            else -> EXTRA_WIDE_DISPLAY
        }

        private const val SMALL_PHONE_SCREEN_WIDTH_PIXELS = 1080
        private const val LARGE_PHONE_SCREEN_WIDTH_PIXELS = 1440
    }
}
