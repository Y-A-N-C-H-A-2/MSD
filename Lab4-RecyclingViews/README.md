# Lab 4 – Recycling Views

Mobile Software Development, TU Dublin.

An Android app in Kotlin that shows a scrolling list of 50 names in a RecyclerView (Assignment Part 2). Part 1 (Intents) uses the sample code from Brightspace and isn't in this folder.

## Open it in Android Studio

1. Clone the repo: `git clone https://github.com/Y-A-N-C-H-A-2/MSD.git`
2. In Android Studio choose **File → Open** and select the **`Lab4-RecyclingViews`** folder (not the repo root).
3. Wait for Gradle sync to finish. If it asks to install SDK 34 or to trust the project, accept.
4. Start an emulator (Device Manager) and press **Run**.

## Project layout

```
Lab4-RecyclingViews/
├── app/
│   ├── build.gradle.kts                 app config + dependencies (incl. recyclerview)
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/recyclingviews/
│       │   ├── Person.kt                data class (the Item)
│       │   ├── PersonAdapter.kt         Adapter + ViewHolder
│       │   └── MainActivity.kt          sets LayoutManager + adapter, 50 names
│       └── res/
│           ├── layout/activity_main.xml RecyclerView in a ConstraintLayout
│           ├── layout/item_person.xml   Item Layout (one TextView per row)
│           └── values/                  strings, theme
├── build.gradle.kts                     plugin versions
├── settings.gradle.kts
└── gradlew / gradle/wrapper             Gradle 8.7
```

Built with Android Gradle Plugin 8.5.2, Kotlin 1.9.24, compileSdk 34, minSdk 24.

## How the pieces map to the lecture

| Element | In this project |
|---|---|
| RecyclerView | `R.id.recyclerView` in `activity_main.xml` |
| Adapter | `PersonAdapter` – `onCreateViewHolder`, `onBindViewHolder`, `getItemCount` |
| ViewHolder | `PersonAdapter.PersonViewHolder` – caches the `TextView` |
| Item | `Person(name)` |
| LayoutManager | `LinearLayoutManager(this)` in `MainActivity` |
| Item Layout | `item_person.xml` |

`onCreateViewHolder` only runs for the handful of rows that fit on screen; when you scroll, rows that leave the screen are reused and `onBindViewHolder` just puts a new name into them.
