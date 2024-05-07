package com.ilesha23.football.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilesha23.football.ui.firstTimeScreen.FirstTimeScreen
import com.ilesha23.football.ui.historyScreen.HistoryScreen
import com.ilesha23.football.ui.loginScreen.LoginScreen
import com.ilesha23.football.ui.newGameScreen.NewGameScreen
import com.ilesha23.football.ui.secondTimeScreen.SecondTimeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginScreen(
                onNewGameClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.NewGame.route) {
                        navigate(Screen.NewGame.route)
                    }
                },
                onHistoryClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.History.route) {
                        navigate(Screen.History.route)
                    }
                }
            )
        }

        composable(Screen.NewGame.route) {
            NewGameScreen(
                onMainMenuClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.Login.route) {
                        navigateWithPopUp(Screen.Login.route)
                    }
                },
                onStartClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.FirstTime.route) {
                        navigate(Screen.FirstTime.route)
                    }
                }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                onBackClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.Login.route) {
                        navigateUp()
                    }
                },
                onMainMenuClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.Login.route) {
                        navigateWithPopUp(Screen.Login.route)
                    }
                }
            )
        }

        composable(Screen.FirstTime.route) {
            FirstTimeScreen(
                onBreakClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.SecondTime.route) {
                        navigate(Screen.SecondTime.route)
                    }
                }
            )
        }

        composable(Screen.SecondTime.route) {
            SecondTimeScreen(
                onFinishClick = {
                    navController.performIfCurrentDestinationDoesntMatch(Screen.Login.route) {
                        navigateWithPopUp(Screen.Login.route)
                        Log.d("LOG_TAG", "nav")
                    }
                }
            )
        }

    }
}

fun NavController.performIfCurrentDestinationDoesntMatch(
    secondDestination: String,
    action: NavController.() -> Unit
) {
    if (currentDestination?.route != secondDestination) {
        action()
    }
}

fun NavController.navigateWithPopUp(
    popUpTo: String,
    route: String = popUpTo
) {
    navigate(route = route) {
        popUpTo(popUpTo) {
            inclusive = popUpTo == route
        }
    }
}