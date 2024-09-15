package com.mart_gant.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mart_gant.tictactoe.controllers.GameController
import com.mart_gant.tictactoe.ui.screens.GameScreen
import com.mart_gant.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {

    private lateinit var gameController: GameController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicjalizacja gameController
        gameController = GameController()

        setContent {
            TicTacToeTheme {
                // Ustawienie głównego ekranu gry
                GameScreen(gameController = gameController)
            }
        }
    }
}
