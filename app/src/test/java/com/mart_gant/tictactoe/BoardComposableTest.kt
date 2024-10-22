package com.mart_gant.tictactoe

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.mart_gant.tictactoe.controllers.GameController
import com.mart_gant.tictactoe.ui.components.BoardComposable
import org.junit.Rule
import org.junit.Test

class BoardComposableTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBoardDisplaysCorrectly() {
        val gameController = GameController()

        composeTestRule.setContent {
            BoardComposable(gameController = gameController, onCellClick = { _, _ -> })
        }

        composeTestRule.onAllNodes(hasClickAction())
            .assertCountEquals(9)
    }

    @Test
    fun testPlayerMoveUpdatesUI() {
        val gameController = GameController()

        composeTestRule.setContent {
            BoardComposable(gameController = gameController, onCellClick = { row, col ->
                gameController.makeMove(row, col)
            })
        }

        composeTestRule.onAllNodes(hasClickAction())[0].performClick()

        composeTestRule.onAllNodes(hasText("X")).assertCountEquals(1)
    }
}