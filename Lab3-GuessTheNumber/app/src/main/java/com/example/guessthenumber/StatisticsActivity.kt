package com.example.guessthenumber

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class StatisticsActivity : AppCompatActivity() {

    // companion object = Kotlin's version of "static", so MainActivity can call recordWin()
    companion object {
        private const val PREFS = "guess_stats"

        fun recordWin(context: Context, guesses: Int) {
            val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            val won = prefs.getInt("gamesWon", 0)
            val total = prefs.getInt("totalGuesses", 0)
            val best = prefs.getInt("best", Int.MAX_VALUE)
            val worst = prefs.getInt("worst", 0)

            prefs.edit()
                .putInt("gamesWon", won + 1)
                .putInt("totalGuesses", total + guesses)
                .putInt("best", minOf(best, guesses))    // fewest guesses
                .putInt("worst", maxOf(worst, guesses))  // most guesses
                .apply()                                 // save in the background
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        showStats()

        // finish() closes this screen; the back stack brings MainActivity back
        findViewById<Button>(R.id.buttonBack).setOnClickListener { finish() }
        findViewById<Button>(R.id.buttonResetStats).setOnClickListener { confirmReset() }
    }

    private fun showStats() {
        val prefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val won = prefs.getInt("gamesWon", 0)
        val total = prefs.getInt("totalGuesses", 0)
        val best = prefs.getInt("best", 0)
        val worst = prefs.getInt("worst", 0)
        val average = if (won > 0) total.toDouble() / won else 0.0

        val text = if (won == 0) {
            "No games won yet.\nPlay a game first!"
        } else {
            "Games won: $won\n\n" +
            "Total guesses: $total\n\n" +
            "Best result: $best guesses\n\n" +
            "Worst result: $worst guesses\n\n" +
            "Average per win: ${"%.1f".format(average)}"
        }
        findViewById<TextView>(R.id.textStats).text = text
    }

    // Extension challenge: ask before clearing
    private fun confirmReset() {
        AlertDialog.Builder(this)
            .setTitle("Reset statistics?")
            .setMessage("This deletes all your saved results.")
            .setPositiveButton("Reset") { _, _ ->
                getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().clear().apply()
                showStats()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
