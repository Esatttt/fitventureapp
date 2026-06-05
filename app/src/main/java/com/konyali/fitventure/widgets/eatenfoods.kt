package com.konyali.fitventure.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konyali.fitventure.R
import com.konyali.fitventure.services.dailyfoods
import com.konyali.fitventure.ui.theme.BgColor
import com.konyali.fitventure.ui.theme.BrandGreen
import com.konyali.fitventure.ui.theme.CardColor
import com.konyali.fitventure.ui.theme.ColorCarb
import com.konyali.fitventure.ui.theme.ColorFat
import com.konyali.fitventure.ui.theme.ColorProtein
import com.konyali.fitventure.ui.theme.Outfit

@Composable
fun eatenfoods(modifiercall: Modifier = Modifier) {
    val bg = MaterialTheme.colorScheme.background
    Card(modifier = modifiercall) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().background(color = bg).padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                top = 16.dp,       // Listenin en üstünde 16dp nefes alma boşluğu
                bottom = 16.dp,   // DİKKAT: Alttaki BottomBar yeşil butonu ezmesin diye ekstra boşluk!
            )
        ) {
            items(dailyfoods.keys.toList()) { food ->
                val pKcal = food.protein * 4
                val cKcal = food.carb * 4
                val fKcal = food.fat * 9
                val dominantType = if (pKcal >= cKcal && pKcal >= fKcal) {
                    "Protein"
                } else if (fKcal >= pKcal && fKcal >= cKcal) {
                    "Fat"
                } else {
                    "Carb"
                }
                Card(
                    modifier = Modifier.fillMaxWidth(0.9f).height(100.dp).background(BgColor),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = CardColor)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Absolute.SpaceAround
                    ) {
                        Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                            foodtype(
                                typecall = dominantType,
                                modifiercall = Modifier.size(68.dp)
                            )
                        }
                        Box(modifier = Modifier.weight(3f)) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    food.name,
                                    fontFamily = Outfit,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    dailyfoods[food].toString(),
                                    fontFamily = Outfit,
                                    fontWeight = FontWeight.Thin
                                )
                                Row(modifier = Modifier.fillMaxWidth(0.65f), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom){
                                    Box(
                                        modifier = Modifier.border(1.dp, ColorProtein, RoundedCornerShape(20.dp))
                                            .background(color = Color(0xFFFDE8E7), shape = RoundedCornerShape(20.dp)) // Pastel kırmızı arka plan, tam yuvarlak
                                            .padding(horizontal = 8.dp, vertical = 2.dp) // İç boşluk
                                    ) {
                                        Text(
                                            text = "%.1f".format(food.protein/100*(dailyfoods[food]?:0)),
                                            color = ColorProtein, // Ana kategori metin rengi (parlak kırmızı)
                                            fontFamily = Outfit, //Outfit Regular fontu
                                            fontSize = 14.sp
                                        )
                                    }
                                    Box(
                                        modifier = Modifier.border(1.dp, ColorCarb, RoundedCornerShape(20.dp))
                                            .background(Color(0xFFFEF8E8), shape = RoundedCornerShape(20.dp)) // Pastel kırmızı arka plan, tam yuvarlak
                                            .padding(horizontal = 8.dp, vertical = 2.dp) // İç boşluk
                                    ) {
                                        Text(
                                            text = "%.1f".format(food.carb/100*(dailyfoods[food]?:0)),
                                            color = ColorCarb, // Ana kategori metin rengi (parlak kırmızı)
                                            fontFamily = Outfit,
                                            fontSize = 14.sp
                                        )
                                    }
                                    Box(
                                        modifier = Modifier.border(1.dp, ColorFat, RoundedCornerShape(20.dp))
                                            .background(Color(0xFFE8F8EE), shape = RoundedCornerShape(20.dp)) // Pastel kırmızı arka plan, tam yuvarlak
                                            .padding(horizontal = 8.dp, vertical = 2.dp) // İç boşluk
                                    ) {
                                        Text(
                                            text = "%.1f".format(food.fat/100*(dailyfoods[food]?:0)),
                                            color = ColorFat, // Ana kategori metin rengi (parlak kırmızı)
                                            fontFamily = Outfit, //Outfit Regular fontu
                                            fontSize = 14.sp
                                        )
                                    }
                                }
                            }
                        }
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                (food.calorie*(dailyfoods[food]?:0)/100).toString(),
                                fontFamily = Outfit,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = BrandGreen
                            )
                        }
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(120.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = BrandGreen,
                                style = Stroke(
                                    width = 4f,
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(15f, 15f),
                                        0f
                                    )
                                ),
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx())
                            )
                        }
                        .background(Color(0xFFaceca1), RoundedCornerShape(16.dp))
                        .clickable {
                            // TODO
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = "Add",
                        tint = BrandGreen,
                        modifier = Modifier.size(48.dp)
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun preview1() {
    eatenfoods(modifiercall = Modifier.width(320.dp))
}