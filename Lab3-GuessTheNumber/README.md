# Lab 3 – Guess the Number

Mobile Software Development, TU Dublin.

An Android app in Kotlin: the player guesses a random number from 1 to 100 and gets "too high", "too low" or "correct" feedback. A second screen shows player statistics saved with SharedPreferences.

## Open it in Android Studio

1. Clone the repo: `git clone https://github.com/Y-A-N-C-H-A-2/MSD.git`
2. In Android Studio choose **File → Open** and select the **`Lab3-GuessTheNumber`** folder (not the repo root).
3. Wait for Gradle sync to finish. If it asks to install SDK 34 or to trust the project, accept.
4. Start an emulator (Device Manager) and press **Run**.

## Project layout

```
Lab3-GuessTheNumber/
├── app/
│   ├── build.gradle.kts                 app config + dependencies
│   └── src/main/
│       ├── AndroidManifest.xml          both activities declared here
│       ├── java/com/example/guessthenumber/
│       │   ├── MainActivity.kt          game logic
│       │   └── StatisticsActivity.kt    stats screen + SharedPreferences
│       └── res/
│           ├── layout/activity_main.xml        ConstraintLayout
│           ├── layout/activity_statistics.xml  LinearLayout
│           └── values/                  strings, colors, theme
├── build.gradle.kts                     plugin versions
├── settings.gradle.kts
└── gradlew / gradle/wrapper             Gradle 8.7
```

Built with Android Gradle Plugin 8.5.2, Kotlin 1.9.24, compileSdk 34, minSdk 24.

## Features

- Random number 1–100 on start and on Reset
- Submit checks the guess; invalid input is rejected
- Statistics screen opened with an explicit Intent
- Games won, total guesses, best, worst and average guesses, kept after the app restarts
- Back to Game button (`finish()`)
- Reset Statistics with a confirmation dialog (extension challenge)

## Deliverables for submission

`MainActivity.kt`, `StatisticsActivity.kt`, `activity_main.xml`, `activity_statistics.xml`, plus a screenshot of the statistics screen.
