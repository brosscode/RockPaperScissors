package com.brandon.rockpaperscissors.view.composables.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandon.rockpaperscissors.R
import com.brandon.rockpaperscissors.domain.Outcome
import com.brandon.rockpaperscissors.domain.Weapon
import com.brandon.rockpaperscissors.view.composables.core.CoreTextButton
import com.brandon.rockpaperscissors.view.composables.core.DisplayLargeText
import com.brandon.rockpaperscissors.view.composables.core.LabelLargeText
import com.brandon.rockpaperscissors.view.composables.theme.dimens
import com.brandon.rockpaperscissors.viewmodel.GameViewModel

@Composable
fun BattleScreen(
    gameState: GameViewModel.GameState,
    onRockTap: () -> Unit,
    onPaperTap: () -> Unit,
    onScissorTap: () -> Unit,
) {
    when (gameState) {
        GameViewModel.GameState.Loading -> CircularProgressIndicator()
        is GameViewModel.GameState.Idle -> BattleField(
            playerWeapon = gameState.playerWeapon,
            enemyWeapon = gameState.enemyWeapon,
            outcome = Outcome.READY,
            onRockTap = onRockTap,
            onPaperTap = onPaperTap,
            onScissorTap = onScissorTap,
        )

        is GameViewModel.GameState.Battle -> BattleField(
            playerWeapon = gameState.playerWeapon,
            enemyWeapon = gameState.enemyWeapon,
            outcome = gameState.outcome,
            onRockTap = onRockTap,
            onPaperTap = onPaperTap,
            onScissorTap = onScissorTap,
        )
    }
}

@Composable
private fun BattleField(
    playerWeapon: Weapon,
    enemyWeapon: Weapon,
    outcome: Outcome,
    onRockTap: () -> Unit,
    onPaperTap: () -> Unit,
    onScissorTap: () -> Unit,
) {
    BattleColumn(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))
        BattleFieldCardContainer(
            playerWeapon = playerWeapon,
            enemyWeapon = enemyWeapon,
            outcome = outcome
        )
        Spacer(modifier = Modifier.weight(1f))
        BattleButtonRow(
            onRockTap = onRockTap,
            onPaperTap = onPaperTap,
            onScissorTap = onScissorTap
        )
    }
}

@Composable
private fun BattleFieldCardContainer(
    playerWeapon: Weapon,
    enemyWeapon: Weapon,
    outcome: Outcome,
) {
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        BattleRow {
            BattleCard(
                modifier = Modifier,
                weapon = enemyWeapon,
                outcome = outcome.getOpposite()
            )
            BattleFieldText(outcome = outcome)
            BattleCard(weapon = playerWeapon, outcome = outcome)
        }
    } else {
        BattleColumn {
            BattleCard(
                weapon = enemyWeapon,
                outcome = outcome.getOpposite()
            )
            BattleFieldText(outcome = outcome)
            BattleCard(weapon = playerWeapon, outcome = outcome)
        }
    }
}

@Composable
private fun BattleButtonRow(
    onRockTap: () -> Unit,
    onPaperTap: () -> Unit,
    onScissorTap: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inversePrimary)
            .padding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BattleButton(text = stringResource(id = R.string.button_text_rock), onClick = onRockTap)
        BattleButton(text = stringResource(id = R.string.button_text_paper), onClick = onPaperTap)
        BattleButton(
            text = stringResource(id = R.string.button_text_scissors),
            onClick = onScissorTap
        )
    }
}

@Composable
fun BattleFieldText(
    modifier: Modifier = Modifier,
    outcome: Outcome,
) {
    BattleRow(modifier = modifier) {
        LabelLargeText(
            modifier = Modifier.align(alignment = Alignment.Bottom),
            text = stringResource(id = R.string.battle_player_text),
            color = Outcome.VICTORY.getColor(),
        )
        DisplayLargeText(
            modifier = Modifier.padding(MaterialTheme.dimens.grid2x),
            text = outcome.getString(),
            color = outcome.getColor(),
        )
        LabelLargeText(
            modifier = Modifier.align(alignment = Alignment.Top),
            text = stringResource(id = R.string.battle_enemy_text),
            color = Outcome.DEFEAT.getColor(),
        )
    }
}

@Composable
private fun BattleCard(
    modifier: Modifier = Modifier,
    weapon: Weapon,
    outcome: Outcome,
) {
    Image(
        modifier = modifier
            .padding(MaterialTheme.dimens.grid2x)
            .sizeIn(
                maxHeight = MaterialTheme.dimens.grid75x,
                maxWidth = MaterialTheme.dimens.grid75x,
            )
            .border(width = 1.dp, color = outcome.getColor()),
        painter = weapon.toPainter(),
        contentDescription = weapon.toContentDesc()
    )
}

@Composable
private fun RowScope.BattleButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    CoreTextButton(
        modifier = modifier.weight(1f),
        text = text,
        onClick = onClick,
    )
}

@Composable
private fun BattleColumn(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        content()
    }
}

@Composable
private fun BattleRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        content()
    }
}
