package com.konyali.fitventure.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
var currentThemeMode by mutableIntStateOf(0) // Başlangıç 1 (Koyu Mod)
val isAppDark: Boolean
    @Composable
    get() = when (currentThemeMode) {
        0 -> false // Zorla Açık
        1 -> true  // Zorla Koyu
        else -> isSystemInDarkTheme() // 2 ise Sisteme bırak
    }
val BrandGreen = Color(0xFF5DD97B)


val ColorProtein: Color
    @Composable get() = if (isAppDark) Color(0xFFFF8A80) else Color(0xFFED6D69)

val ColorCarb: Color
    @Composable get() = if (isAppDark) Color(0xFFFFD54F) else Color(0xFFF4C542)

val ColorFat: Color
    @Composable get() = if (isAppDark) Color(0xFFC5E1A5) else Color(0xFF8DB600)

val BgColor: Color
    @Composable get() = if (isAppDark) Color(0xFF0F172A) else Color(0xFFf5f3f4)

val CardColor: Color
    @Composable get() = if (isAppDark) Color(0xFF1E293B) else Color(0xFFdee2e6)

val BorderColor: Color
    @Composable get() = if (isAppDark) Color(0xFF334155) else Color(0xFFadb5bd)

val LayerColor: Color
    @Composable get() = if (isAppDark) Color(0xFF111827) else Color(0xFFadb5bd)

val TextColor: Color
    @Composable get() = if (isAppDark) Color(0xFFE0E0E0) else Color(0xFF1A1A1A)

val RingBgColor: Color
    @Composable get() = if (isAppDark) Color(0xFF334155) else Color(0xFFE2E8F0)