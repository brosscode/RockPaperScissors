package com.brandon.rockpaperscissors.domain

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.brandon.rockpaperscissors.R
import com.brandon.rockpaperscissors.view.composables.theme.colorDefeat
import com.brandon.rockpaperscissors.view.composables.theme.colorDraw
import com.brandon.rockpaperscissors.view.composables.theme.colorVictory

enum class Outcome {
    READY,
    TIE,
    VICTORY,
    DEFEAT;

    @Composable
    fun getString() = when (this) {
        READY -> stringResource(id = R.string.battle_ready_text)
        TIE -> stringResource(id = R.string.battle_tie_text)
        VICTORY -> stringResource(id = R.string.battle_victory_text)
        DEFEAT -> stringResource(id = R.string.battle_defeat_text)
    }

    @Composable
    fun getColor() = when (this) {
        READY -> MaterialTheme.colorScheme.onBackground
        TIE -> colorDraw
        VICTORY -> colorVictory
        DEFEAT -> colorDefeat
    }

    fun getOpposite() = when (this) {
        VICTORY -> DEFEAT
        DEFEAT -> VICTORY
        else -> this
    }

    companion object {
        fun determineWinner(playerWeapon: Weapon, opponentWeapon: Weapon) = when {
            opponentWeapon == playerWeapon -> TIE
            playerWeapon == Weapon.NONE -> DEFEAT
            opponentWeapon == Weapon.NONE -> VICTORY
            opponentWeapon == Weapon.ROCK && playerWeapon == Weapon.SCISSORS -> DEFEAT
            opponentWeapon == Weapon.PAPER && playerWeapon == Weapon.ROCK -> DEFEAT
            opponentWeapon == Weapon.SCISSORS && playerWeapon == Weapon.PAPER -> DEFEAT
            playerWeapon == Weapon.ROCK && opponentWeapon == Weapon.SCISSORS -> VICTORY
            playerWeapon == Weapon.PAPER && opponentWeapon == Weapon.ROCK -> VICTORY
            playerWeapon == Weapon.SCISSORS && opponentWeapon == Weapon.PAPER -> VICTORY
            else -> throw Exception(INVALID_OUTCOME)
        }

        private const val INVALID_OUTCOME = "Invalid Outcome"
    }
}
