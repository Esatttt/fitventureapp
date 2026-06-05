package com.konyali.fitventure.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konyali.fitventure.services.dailyfoods
import com.konyali.fitventure.ui.theme.BgColor
import com.konyali.fitventure.ui.theme.ColorCarb
import com.konyali.fitventure.ui.theme.ColorFat
import com.konyali.fitventure.ui.theme.ColorProtein
import com.konyali.fitventure.ui.theme.Outfit
import com.konyali.fitventure.ui.theme.isAppDark

@Composable
fun showcalorie(modifiercall: Modifier = Modifier) {

    val ArcBackground = if(isAppDark){Color(0xFFebe8e9)}else{Color(0xFFebe8e9)}

    val ColorProtein = ColorProtein
    val ColorCarb = ColorCarb
    val ColorFat = ColorFat
    val Background = BgColor

    var currentKcal = 0
    var dailyprotein = 0
    var dailycarb = 0
    var dailyfat = 0
    for ((food, gram) in dailyfoods) {
        currentKcal += gram * food.calorie / 100
        dailyprotein += (gram * food.protein / 100).toInt()
        dailycarb += (gram * food.carb / 100).toInt()
        dailyfat += (gram * food.fat / 100).toInt()
    }

    // 2. ÇİZİM İÇİN KALORİ DÖNÜŞÜMLERİ (Protein/Karb=4, Yağ=9)
    val proteinKcal = dailyprotein * 4f
    val fatKcal = dailyfat * 9f
    val carbKcal = dailycarb * 4f
    val maxKcal = 2200 // Şimdilik hedefi 2200 sabit bıraktım

    // 3. ÇİZİM MOTORU
    Box(contentAlignment = Alignment.Center, modifier = modifiercall) {

        Canvas(modifier = Modifier.fillMaxHeight(0.8f).aspectRatio(1f)) {
            val strokeWidth = 50f

            // Gri Arka Plan Halkası
            drawArc(color = ArcBackground, 0f, 360f, false, style = Stroke(strokeWidth))

            if (maxKcal > 0) {
                val fatAngle = (fatKcal / maxKcal) * 360f
                val proteinAngle = (proteinKcal / maxKcal) * 360f
                val carbAngle = (carbKcal / maxKcal) * 360f

                var start = -90f // Saat 12 yönü

                drawArc(ColorFat, start, fatAngle, false, style = Stroke(strokeWidth, cap = StrokeCap.Butt))
                start += fatAngle

                drawArc(ColorProtein, start, proteinAngle, false, style = Stroke(strokeWidth, cap = StrokeCap.Butt))
                start += proteinAngle

                drawArc(ColorCarb, start, carbAngle, false, style = Stroke(strokeWidth, cap = StrokeCap.Butt))
            }
        }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$currentKcal", fontFamily = Outfit, fontSize = 42.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "/ $maxKcal kcal", fontFamily = Outfit, fontSize = 16.sp, color = Color.Gray)
        }
    }
}
@Preview
@Composable
fun preview(){
    showcalorie(modifiercall = Modifier.fillMaxWidth())
}

