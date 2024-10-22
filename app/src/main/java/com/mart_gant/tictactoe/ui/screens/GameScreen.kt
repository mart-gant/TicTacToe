package com.mart_gant.tictactoe.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mart_gant.tictactoe.controllers.GameController
import com.mart_gant.tictactoe.ui.components.BoardComposable

@Composable
fun GameScreen(gameController: GameController) {
    var winner by remember { mutableStateOf<String?>(null) }
    var currentPlayer by remember { mutableStateOf(gameController.getCurrentPlayer()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tic Tac Toe",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (gameController.isGameOver()) {
            Text(
                text = if (gameController.getWinner() != null) {
                    "Winner: ${gameController.getWinner()}"
                } else {
                    "It's a tie!"
                },
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = "Current Player: $currentPlayer",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        BoardComposable(gameController) { row, col ->
            gameController.handleTap(row, col)
            winner = gameController.getWinner()
            currentPlayer = gameController.getCurrentPlayer()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            gameController.resetGame()
            winner = null
            currentPlayer = gameController.getCurrentPlayer()
        }) {
            Text(text = "Reset Game")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    val gameController = GameController()
    GameScreen(gameController)
}