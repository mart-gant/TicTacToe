package com.mart_gant.tictactoe.models

class Board {
    var board = Array(3) { Array(3) { "" } }

    fun checkWinner(player: String): Boolean {
        for (row in board) {
            if (row.all { it == player }) return true
        }

        for (col in 0..2) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) return true
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true

        return false
    }

    fun isFull(): Boolean {
        return board.all { row -> row.all { it.isNotEmpty() } }
    }

    fun reset() {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = ""
            }
        }
    }
}
