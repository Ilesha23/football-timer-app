package com.ilesha23.football.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilesha23.football.ui.firstTimeScreen.FirstTimeScreen
import com.ilesha23.football.ui.historyScreen.HistoryScreen
import com.ilesha23.football.ui.loginScreen.LoginScreen
import com.ilesha23.football.ui.newGameScreen.NewGameScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.FirstTime.route) {

        composable(Screen.Login.route) {
            LoginScreen()
        }

        composable(Screen.NewGame.route) {
            NewGameScreen()
        }

        composable(Screen.History.route) {
            HistoryScreen()
        }

        composable(Screen.FirstTime.route) {
            FirstTimeScreen()
        }

        composable(Screen.SecondTime.route) {
            HistoryScreen()
        }

    }
}