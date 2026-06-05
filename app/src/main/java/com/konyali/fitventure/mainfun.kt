package com.konyali.fitventure

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import bottombarapp
import com.konyali.fitventure.screens.exercisescreen
import com.konyali.fitventure.screens.macroscreen
import com.konyali.fitventure.ui.theme.FitventureTheme

@Composable
fun mainapp() {
    FitventureTheme {
        val navcontroller = rememberNavController()
        val navBackStackEntry by navcontroller.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val bgColor = MaterialTheme.colorScheme.background

        Column(modifier = Modifier.fillMaxSize().background(color = bgColor)) {
            Box(modifier = Modifier.weight(1f).background(color = bgColor)) {
                NavHost(navController = navcontroller, startDestination = "macroscreen",
                    enterTransition = {
                        val fromRoute = initialState.destination.route
                        val toRoute = targetState.destination.route
                        if (fromRoute == "macroscreen" && toRoute == "exercisescreen") {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> fullWidth },
                                animationSpec = tween(300)
                            )
                        } else {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> -fullWidth },
                                animationSpec = tween(300)
                            )
                        }
                    },
                    exitTransition = {
                        val fromRoute = initialState.destination.route
                        val toRoute = targetState.destination.route

                        if (fromRoute == "macroscreen" && toRoute == "exercisescreen") {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> -fullWidth },
                                animationSpec = tween(300)
                            )
                        } else {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> fullWidth },
                                animationSpec = tween(300)
                            )
                        }
                    }
                )
                {
                    composable("macroscreen") { macroscreen() }
                    composable("exercisescreen") { exercisescreen() }
                }
            }
            bottombarapp(modifiercall = Modifier.height(80.dp),
                onMacroClick = { navcontroller.navigate("macroscreen") { launchSingleTop = true } },
                onGYMclick = { navcontroller.navigate("exercisescreen") { launchSingleTop = true } },
                currentRoute = currentRoute
            )
        }
    }
}