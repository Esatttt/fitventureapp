package com.konyali.fitventure.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.konyali.fitventure.ui.theme.BgColor
import com.konyali.fitventure.ui.theme.FitventureTheme
import com.konyali.fitventure.widgets.eatenfoods
import com.konyali.fitventure.widgets.fitventurebrand
import com.konyali.fitventure.widgets.showcalorie
import com.konyali.fitventure.widgets.showmacros

@Composable
fun macroscreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp)) {
            fitventurebrand(modifiercall = Modifier.fillMaxWidth().weight(0.5f).background(color = BgColor).padding(horizontal = 8.dp))
            showcalorie(modifiercall = Modifier.fillMaxWidth().weight(5f).background(color = BgColor))
            showmacros(modifiercall = Modifier.fillMaxWidth().weight(1f).padding(vertical = 4.dp).background(color = BgColor))
            eatenfoods(modifiercall = Modifier.fillMaxWidth().weight(7f).background(color = BgColor))
        }
    }
}