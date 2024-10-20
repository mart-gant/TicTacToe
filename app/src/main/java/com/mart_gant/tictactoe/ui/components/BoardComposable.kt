package com.mart_gant.tictactoe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mart_gant.tictactoe.controllers.GameController

@Composable
fun BoardComposable(gameController: GameController, onCellClick: (row: Int, col: Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in 0..2) {
            Row {
                for (col in 0..2) {
                    CellComposable(
                        symbol = gameController.getBoard()[row][col] ?: "",
                        onClick = { onCellClick(row, col) }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        StatusMessage(gameController)
    }
}

@Composable
fun CellComposable(symbol: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            .clickable(enabled = symbol.isEmpty()) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StatusMessage(gameController: GameController) {
    val message = remember {
        when {
            gameController.isGameOver() && gameController.getWinner() != null -> "Player ${gameController.getWinner()} wins!"
            gameController.isGameOver() -> "It's a draw!"
            else -> "Player ${gameController.getCurrentPlayer()}'s turn"
        }
    }
    Text(
        text = message,
        style = MaterialTheme.typography.bodyLarge,
        color = if (gameController.isGameOver()) Color.Red else Color.Black,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBoardComposable() {
    val gameController = GameController()
    BoardComposable(gameController = gameController) { row, col -> gameController.handleTap(row, col) }
}
