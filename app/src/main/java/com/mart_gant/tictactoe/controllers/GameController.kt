package com.mart_gant.tictactoe.controllers

class GameController {

    private val board: MutableList<MutableList<String?>> = MutableList(3) { MutableList(3) { null } }

    private var currentPlayer: String = "X"
    private var winner: String? = null
    private var gameOver: Boolean = false

    // Funkcja do uzyskania obecnego stanu planszy
    fun getBoard(): List<List<String?>> {
        return board
    }

    fun handleTap(row: Int, col: Int) {
        if (row in 0..2 && col in 0..2 && board[row][col] == null && !gameOver) {
            board[row][col] = currentPlayer
            if (checkGameState(row, col)) {
                gameOver = true
                winner = currentPlayer
            } else if (board.flatten().all { it != null }) {
                gameOver = true
            }
            switchPlayer()
        }
    }

    fun getCurrentPlayer(): String {
        return currentPlayer
    }

    fun getWinner(): String? {
        return winner
    }

    fun isGameOver(): Boolean {
        return gameOver
    }

    fun resetGame() {
        board.forEach { row -> row.fill(null) }
        currentPlayer = "X"
        winner = null
        gameOver = false
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == "X") "O" else "X"
    }

    private fun checkGameState(row: Int, col: Int): Boolean {
        // Sprawdzenie wiersza, kolumny i przekątnych
        val winConditions = listOfNotNull(
            (0..2).map { board[row][it] }, // Wiersz
            (0..2).map { board[it][col] }, // Kolumna
            if (row == col) (0..2).map { board[it][it] } else null, // Przekątna
            if (row + col == 2) (0..2).map { board[it][2 - it] } else null // Przekątna odwrotna
        )

        return winConditions.any { line -> line.all { it == currentPlayer } }
    }
}
