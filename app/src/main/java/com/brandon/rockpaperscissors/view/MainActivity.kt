package com.brandon.rockpaperscissors.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.brandon.rockpaperscissors.domain.Weapon
import com.brandon.rockpaperscissors.view.composables.screens.BattleScreen
import com.brandon.rockpaperscissors.view.composables.theme.FormFactor
import com.brandon.rockpaperscissors.view.composables.theme.LocalFormFactor
import com.brandon.rockpaperscissors.view.composables.theme.RockPaperScissorsTheme
import com.brandon.rockpaperscissors.viewmodel.ConfigurationViewModel
import com.brandon.rockpaperscissors.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {

    private val configViewModel: ConfigurationViewModel by viewModels()
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (configViewModel.configState.value.windowManager == null)
            configViewModel.createWindowManager(this)
        setContent {
            val configState by remember { mutableStateOf(configViewModel.configState.value.screenWidth) }
            val formFactor by remember(configState) {
                mutableStateOf(FormFactor.getFactor(configState))
            }
            val gameState = gameViewModel.state.collectAsState()
            CompositionLocalProvider(LocalFormFactor provides formFactor) {
                RockPaperScissorsTheme {
                    BattleScreen(
                        gameState = gameState.value,
                        onRockTap = { gameViewModel.battle(Weapon.ROCK) },
                        onPaperTap = { gameViewModel.battle(Weapon.PAPER) },
                        onScissorTap = { gameViewModel.battle(Weapon.SCISSORS) }
                    )
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configViewModel.updateConfig()
    }
}
