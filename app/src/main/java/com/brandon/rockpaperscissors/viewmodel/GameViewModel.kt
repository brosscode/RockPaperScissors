package com.brandon.rockpaperscissors.viewmodel

import androidx.lifecycle.ViewModel
import com.brandon.rockpaperscissors.domain.Outcome
import com.brandon.rockpaperscissors.domain.Weapon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    sealed interface GameState {
        object Loading : GameState

        data class Idle(
            val playerWeapon: Weapon = Weapon.NONE,
            val enemyWeapon: Weapon = Weapon.NONE,
        ) : GameState

        data class Battle(
            val playerWeapon: Weapon,
            val enemyWeapon: Weapon,
            val outcome: Outcome
        ) : GameState
    }

    private val _state = MutableStateFlow<GameState>(GameState.Idle())
    val state: StateFlow<GameState> = _state.asStateFlow()

    fun battle(playerWeapon: Weapon) = Weapon.pickRandomWeapon().run {
        _state.value = GameState.Battle(
            playerWeapon = playerWeapon,
            enemyWeapon = this,
            outcome = Outcome.determineWinner(
                playerWeapon,
                this
            )
        )
    }

}
