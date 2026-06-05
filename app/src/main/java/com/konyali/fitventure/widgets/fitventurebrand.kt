package com.konyali.fitventure.widgets

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.konyali.fitventure.ui.theme.BrandGreen
import com.konyali.fitventure.ui.theme.Outfit

@Composable
fun fitventurebrand(modifiercall: Modifier = Modifier){
    Box(modifiercall){
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center){
                Text("FitVenture", fontFamily = Outfit, fontWeight = FontWeight.Bold, fontSize = 28.sp, color = BrandGreen)
            }

        }
    }


}