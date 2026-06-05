package com.konyali.fitventure.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun FitventureTheme(
    // darkTheme parametresini sildik, çünkü artık kontrol BİZİM isAppDark'ımızda!
    content: @Composable () -> Unit
) {
    // Bizim kurduğumuz 0-1-2 karar mekanizmasını Google'ın şemasına bağlıyoruz
    val colorScheme = if (isAppDark) {
        darkColorScheme(
            primary        = BrandGreen,
            background     = BgColor,      // Bizim akıllı zemin rengimiz
            surface        = CardColor,    // Bizim akıllı kart rengimiz
            onBackground   = TextColor,    // Bizim akıllı yazı rengimiz
            onSurface      = TextColor,
            outline        = BorderColor,  // Çerçevelerimiz
            surfaceVariant = LayerColor    // Kutularımız
        )
    } else {
        lightColorScheme(
            primary        = BrandGreen,
            background     = BgColor,
            surface        = CardColor,
            onBackground   = TextColor,
            onSurface      = TextColor,
            outline        = BorderColor,
            surfaceVariant = LayerColor
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography, // O jilet gibi Outfit fontumuz hala güvende
        content     = content
    )
}