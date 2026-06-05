package com.konyali.fitventure.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.konyali.fitventure.R
import com.konyali.fitventure.services.dailyfoods
import com.konyali.fitventure.ui.theme.BgColor
import com.konyali.fitventure.ui.theme.ColorCarb
import com.konyali.fitventure.ui.theme.ColorFat
import com.konyali.fitventure.ui.theme.ColorProtein
import com.konyali.fitventure.ui.theme.Outfit

@Composable
fun showmacros(modifiercall: Modifier = Modifier) {
    var dailyprotein = 0
    var dailycarb = 0
    var dailyfat = 0
    for ((food, gram) in dailyfoods) {
        dailyprotein += (gram * food.protein / 100).toInt()
        dailycarb += (gram * food.carb / 100).toInt()
        dailyfat += (gram * food.fat / 100).toInt()
    }
    Box(modifier = modifiercall, contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f),
            shape = RoundedCornerShape(20,),
            colors = CardDefaults.cardColors(containerColor = BgColor)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                // PROTEIN
                Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.Center) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_protein),
                                contentDescription = "Protein",
                                modifier = Modifier.size(20.dp),
                                tint = ColorProtein
                            )
                            Text("Protein", fontFamily = Outfit)
                        }
                        Text(dailyprotein.toString() + "g", fontFamily = Outfit)
                        Box(modifier = Modifier.width(42.dp).height(4.dp)
                            .background(color = ColorProtein, shape = RoundedCornerShape(2.dp)))
                    }
                }

                // CARB
                Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.Center) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_carb),
                                contentDescription = "Carbohydrate",
                                modifier = Modifier.size(20.dp),
                                tint = ColorCarb
                            )
                            Text("Carb", fontFamily = Outfit)
                        }
                        Text(dailycarb.toString() + "g", fontFamily = Outfit)
                        Box(modifier = Modifier.width(42.dp).height(4.dp)
                            .background(color = ColorCarb, shape = RoundedCornerShape(2.dp)))
                    }
                }

                // FAT
                Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.Center) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_fat),
                                contentDescription = "Fat",
                                modifier = Modifier.size(20.dp),
                                tint = ColorFat
                            )
                            Text("Fat", fontFamily = Outfit)
                        }
                        Text(dailyfat.toString() + "g", fontFamily = Outfit)
                        Box(modifier = Modifier.width(42.dp).height(4.dp)
                            .background(color = ColorFat, shape = RoundedCornerShape(2.dp)))
                    }
                }
            }
        }
    }
}