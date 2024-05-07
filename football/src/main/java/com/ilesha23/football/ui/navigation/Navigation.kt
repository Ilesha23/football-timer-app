package com.ilesha23.football.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilesha23.football.ui.loginScreen.LoginScreen
import com.ilesha23.football.ui.newGameScreen.NewGameScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.NewGame.route) {

        composable(Screen.Login.route) {
            LoginScreen()
        }

        composable(Screen.NewGame.route) {
            NewGameScreen()
        }

    }
}