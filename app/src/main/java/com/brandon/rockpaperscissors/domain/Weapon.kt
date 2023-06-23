package com.brandon.rockpaperscissors.domain

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.brandon.rockpaperscissors.R
import kotlin.random.Random

enum class Weapon {
    NONE,
    ROCK,
    PAPER,
    SCISSORS;

    @Composable
    fun toPainter() = when (this) {
        NONE -> painterResource(id = R.drawable.nothing)
        ROCK -> painterResource(id = R.drawable.rock)
        PAPER -> painterResource(id = R.drawable.paper)
        SCISSORS -> painterResource(id = R.drawable.scissors)
    }

    @Composable
    fun toContentDesc() = when (this) {
        NONE -> stringResource(id = R.string.button_text_nothing)
        ROCK -> stringResource(id = R.string.button_text_rock)
        PAPER -> stringResource(id = R.string.button_text_paper)
        SCISSORS -> stringResource(id = R.string.button_text_scissors)
    }

    companion object {
        fun pickRandomWeapon() = when (Random.nextInt(1, 4)) {
            ROCK.ordinal -> ROCK
            PAPER.ordinal -> PAPER
            SCISSORS.ordinal -> SCISSORS
            else -> NONE
        }
    }
}
