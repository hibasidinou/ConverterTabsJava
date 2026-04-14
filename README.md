# 🌡️ ConverterTabsJava — Android App

A native Android application developed using Java and XML that allows users to convert temperatures (°C ↔ °F) and distances (Km ↔ Miles) through a clean tabbed interface with a light sky blue Material Design theme.


## Features

* Two-tab navigation using `TabLayout` + `ViewPager2`
* Temperature conversion — Celsius to Fahrenheit and vice versa
* Distance conversion — Kilometres to Miles and vice versa
* Material Design outlined input fields and buttons
* Confirmation dialog on back press and menu "Quitter"
* Light sky blue theme — consistent across toolbar, tabs, and result cards
* Custom app icon via Android Image Asset Studio


## Technologies

* Java
* XML
* Android Studio
* Material Components for Android (`com.google.android.material:material:1.12.0`)
* AndroidX ViewPager2 (`androidx.viewpager2:viewpager2:1.0.0`)


## Project Structure

```
ConverterTabsJava/
└── app/
    └── src/
        └── main/
            ├── java/com/example/convertertabsjava/
            │   ├── MainActivity.java
            │   ├── PagerAdapter.java
            │   ├── TemperatureFragment.java
            │   └── DistanceFragment.java
            └── res/
                ├── layout/
                │   ├── activity_main.xml
                │   ├── fragment_temperature.xml
                │   └── fragment_distance.xml
                ├── menu/
                │   └── menu_main.xml
                ├── drawable/
                │   └── result_bg.xml
                └── values/
                    ├── colors.xml
                    └── themes.xml
```


## How it works

The application is built around a single `Activity` hosting two `Fragment`s managed by a `ViewPager2`.

* The app opens directly on the Temperature tab
* The user selects a conversion direction using `RadioButton`s (°C → °F or °F → °C)
* The user enters a numeric value and taps **Convertir**
* The result appears instantly in a styled result card below
* Swiping left opens the Distance tab with the same interaction pattern
* Tapping **Quitter** in the toolbar menu or pressing the back button shows a confirmation `AlertDialog`

### Conversion formulas used

```
Celsius → Fahrenheit :   F = (C × 9/5) + 32
Fahrenheit → Celsius :   C = (F − 32) × 5/9

Kilometres → Miles :     mi = km × 0.621371
Miles → Kilometres :     km = mi / 0.621371
```


## Architecture

| File | Role |
|---|---|
| `MainActivity.java` | Single entry point — initialises tabs, toolbar, menu, back press dialog |
| `PagerAdapter.java` | Extends `FragmentStateAdapter` — supplies the two fragments to `ViewPager2` |
| `TemperatureFragment.java` | Inflates layout, reads input, applies temperature formula, displays result |
| `DistanceFragment.java` | Inflates layout, reads input, applies distance formula, displays result |
| `activity_main.xml` | Root layout — `Toolbar` + `TabLayout` + `ViewPager2` |
| `fragment_temperature.xml` | Fragment UI — `RadioGroup`, `TextInputLayout`, `MaterialButton`, result `TextView` |
| `fragment_distance.xml` | Fragment UI — same structure as temperature fragment |
| `menu_main.xml` | Overflow menu with single "Quitter" item |
| `result_bg.xml` | Rounded border drawable for the result card |
| `colors.xml` | Sky blue palette — `sky_blue_light`, `sky_blue_mid`, `sky_blue_dark`, `sky_blue_text` |


## Min SDK

API 24 — Android 7.0 (Nougat)


## Demo


https://github.com/user-attachments/assets/9d517835-64b3-4f76-b830-4ff10b7de89e


## Notes

This project was built to practice core Android development concepts including fragment lifecycle management, `ViewPager2` with `TabLayoutMediator`, `FragmentStateAdapter`, Material Design components (`TextInputLayout`, `MaterialButton`), menu inflation and item selection, and `AlertDialog` for user confirmation.
