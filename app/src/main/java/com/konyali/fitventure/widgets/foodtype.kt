package com.konyali.fitventure.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.konyali.fitventure.R

@Composable
fun foodtype(typecall: String, modifiercall: Modifier = Modifier) {
    val (iconRes, iconTint, bgColor) = when (typecall) {
        "Fat" -> Triple(R.drawable.ic_fat, Color(0xFF5DD97B), Color(0xFFE8F8EE))
        "Carb" -> Triple(R.drawable.ic_carb, Color(0xFFF4C542), Color(0xFFFEF8E8))
        else -> Triple(R.drawable.ic_protein, Color(0xFFED6D69), Color(0xFFFDE8E7))
    }
    Box(
        modifier = modifiercall
            .background(color = bgColor, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = typecall,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
    }
}