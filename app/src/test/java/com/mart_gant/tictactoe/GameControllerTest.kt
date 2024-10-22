package com.mart_gant.tictactoe

import com.mart_gant.tictactoe.controllers.GameController
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameControllerTest {

    private lateinit var gameController: GameController

    @Before
    fun setUp() {
        gameController = GameController()
    }

    @Test
    fun testInitialBoardIsEmpty() {
        val board = gameController.getBoard()
        for (row in board) {
            for (cell in row) {
                assertNull("Komórka powinna być pusta", cell)
            }
        }
    }

    @Test
    fun testPlayerMove() {
        gameController.makeMove(0, 0)  // Gracz X robi ruch
        val board = gameController.getBoard()
        assertEquals("Pierwsza komórka powinna mieć X", "X", board[0][0])
    }

    @Test
    fun testWinningCondition() {
        gameController.makeMove(0, 0)  // Gracz X
        gameController.makeMove(1, 0)  // Gracz O
        gameController.makeMove(0, 1)  // Gracz X
        gameController.makeMove(1, 1)  // Gracz O
        gameController.makeMove(0, 2)  // Gracz X wygrał

        val winner = gameController.checkWinner()
        assertEquals("Zwycięzca powinien być X", "X", winner)
    }
}


