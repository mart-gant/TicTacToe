This project is a simple implementation of the classic Tic-Tac-Toe game using Jetpack Compose. The application allows two players to play against each other on the same device.

Features
Two-player mode: Play against a friend on the same device.
Jetpack Compose UI: The user interface is built entirely using Jetpack Compose.
State Management: The game state is efficiently managed using ViewModel and LiveData.
Winner Detection: The app detects and announces the winner based on the game state (rows, columns, diagonals).
Tested: Unit and UI tests are implemented to ensure the correctness of the game logic and interface.

Getting Started
Prerequisites
Android Studio 4.2 or later
Kotlin 1.5 or later
Gradle 7.0 or later

How to Run
Clone the repository:
git clone https://github.com/yourusername/tictactoe-jetpack-compose.git
Open the project in Android Studio.

Build and run the app on an emulator or a physical device.

Usage
Tap on any cell to place your mark (X or O).
The game will automatically detect if there is a winner and reset for a new game.
The game state alternates between "X" and "O" after each move.
Testing
Unit tests for the game logic and UI are located in the test/ directory.

Run tests
To run the tests, use the following command in Android Studio:

Right-click on the test folder and select Run Tests.

Alternatively, you can run all tests using Gradle:
./gradlew test
