# Lab 3 – Guess the Number

Mobile Software Development, TU Dublin.

An Android app in Kotlin: the player guesses a random number from 1 to 100 and gets "too high", "too low" or "correct" feedback. A second screen shows player statistics saved with SharedPreferences.

## Files

| File | Goes in (Android Studio) |
|---|---|
| `kotlin/MainActivity.kt` | `app/src/main/java/<your package>/` |
| `kotlin/StatisticsActivity.kt` | `app/src/main/java/<your package>/` |
| `layout/activity_main.xml` | `app/src/main/res/layout/` |
| `layout/activity_statistics.xml` | `app/src/main/res/layout/` |

## Features

- Random number 1–100 on start and on Reset
- Submit checks the guess; invalid input is rejected
- Statistics screen opened with an explicit Intent
- Games won, total guesses, best, worst and average guesses, kept after the app restarts
- Back to Game button (`finish()`)
- Reset Statistics with a confirmation dialog (extension challenge)
