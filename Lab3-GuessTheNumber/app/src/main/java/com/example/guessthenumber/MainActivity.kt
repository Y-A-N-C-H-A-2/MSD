package com.example.guessthenumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Game state
    private var secretNumber = 0      // the number to guess
    private var guessCount = 0        // guesses in the current game
    private var gameOver = false      // true once the player wins

    // Views we use in more than one function
    private lateinit var editGuess: EditText
    private lateinit var textFeedback: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)          // inflate the XML layout

        // Find the views by their IDs
        editGuess = findViewById(R.id.editGuess)
        textFeedback = findViewById(R.id.textFeedback)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonStats = findViewById<Button>(R.id.buttonStats)

        newGame()                                       // random number when the app starts

        // Register click listeners (lambdas)
        buttonSubmit.setOnClickListener { checkGuess() }
        buttonReset.setOnClickListener { newGame() }
        buttonStats.setOnClickListener {
            // Explicit intent: we name the exact Activity to open
            startActivity(Intent(this, StatisticsActivity::class.java))
        }
    }

    private fun newGame() {
        secretNumber = (1..100).random()                // random number 1..100 (inclusive)
        guessCount = 0
        gameOver = false
        editGuess.text.clear()
        textFeedback.text = ""
    }

    private fun checkGuess() {
        if (gameOver) {
            textFeedback.text = "You already won! Press Reset to play again."
            return
        }

        // EditText -> String -> Int. toIntOrNull() gives null instead of crashing
        val guess = editGuess.text.toString().toIntOrNull()
        if (guess == null || guess !in 1..100) {
            textFeedback.text = "Please enter a number between 1 and 100."
            return
        }

        guessCount++
        when {
            guess > secretNumber -> textFeedback.text = "Too high! Try again."
            guess < secretNumber -> textFeedback.text = "Too low! Try again."
            else -> {
                textFeedback.text = "Correct! You got it in $guessCount guesses."
                gameOver = true
                StatisticsActivity.recordWin(this, guessCount)   // save to SharedPreferences
            }
        }
        editGuess.text.clear()
    }
}
