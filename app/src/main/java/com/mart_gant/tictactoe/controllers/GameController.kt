package com.mart_gant.tictactoe.controllers

class GameController {

    private val board: MutableList<MutableList<String?>> = MutableList(3) { MutableList(3) { null } }

    private var currentPlayer: String = "X"
    private var winner: String? = null
    private var gameOver: Boolean = false

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
        val winConditions = listOfNotNull(
            (0..2).map { board[row][it] },
            (0..2).map { board[it][col] },
            if (row == col) (0..2).map { board[it][it] } else null,
            if (row + col == 2) (0..2).map { board[it][2 - it] } else null
        )

        return winConditions.any { line -> line.all { it == currentPlayer } }
    }

    fun makeMove(row: Int, col: Int) {
        if (board[row][col] == null) {
            board[row][col] = currentPlayer

            currentPlayer = if (currentPlayer == "X") "O" else "X"
        }
    }

    fun checkWinner(): String? {
        for (row in 0..2) {
            if (board[row][0] != null && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return board[row][0]
            }
        }

        for (col in 0..2) {
            if (board[0][col] != null && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return board[0][col]
            }
        }

        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2]
        }
        return null
    }
}
