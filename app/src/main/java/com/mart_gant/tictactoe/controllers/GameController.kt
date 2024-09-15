package com.mart_gant.tictactoe.controllers

import com.mart_gant.tictactoe.models.Board

class GameController {
    var board = Board()
    var currentPlayer = "X"
    var gameEnd = false
    var winner: String? = null

    // Obsługuje ruchy graczy
    fun handleTap(row: Int, col: Int) {
        // Sprawdza, czy komórka jest pusta i gra nie została zakończona
        if (board.board[row][col].isEmpty() && !gameEnd) {
            board.board[row][col] = currentPlayer

            // Sprawdzenie, czy obecny gracz wygrał
            if (board.checkWinner(currentPlayer)) {
                gameEnd = true
                winner = currentPlayer
            } else if (board.isFull()) {
                // Jeśli plansza jest pełna, gra kończy się remisem
                gameEnd = true
                winner = null
            } else {
                // Przełącz na następnego gracza
                currentPlayer = if (currentPlayer == "X") "O" else "X"
            }
        }
    }

    // Resetuje stan gry
    fun resetGame() {
        board.reset()
        currentPlayer = "X"
        gameEnd = false
        winner = null
    }

    // Sprawdza, czy gra została zakończona
    fun isGameOver(): Boolean {
        return gameEnd
    }

    // Zwraca zwycięzcę lub null, jeśli był remis
    fun getWinner(): String? {
        return winner
    }

    // Zwraca aktualnego gracza
    fun getCurrentPlayer(): String {
        return currentPlayer
    }
}
