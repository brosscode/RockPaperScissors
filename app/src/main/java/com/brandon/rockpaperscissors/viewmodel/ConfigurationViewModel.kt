package com.brandon.rockpaperscissors.viewmodel

import android.content.Context
import android.view.WindowManager
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConfigurationViewModel : ViewModel() {

    data class ConfigState(
        val windowManager: WindowManager? = null,
        val screenWidth: Int = 0
    )

    private val _configState = MutableStateFlow(ConfigState())
    val configState: StateFlow<ConfigState> = _configState.asStateFlow()

    fun createWindowManager(context: Context) {
        _configState.value = _configState.value.copy(
            windowManager = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
        )
        updateConfig()
    }

    fun updateConfig() {
        _configState.value = _configState.value.copy(screenWidth = getScreenWidthInPx())
    }

    private fun getScreenWidthInPx(): Int =
        _configState.value.windowManager?.defaultDisplay?.width ?: _configState.value.screenWidth
}
