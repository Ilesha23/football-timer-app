package com.ilesha23.football.ui.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object History : Screen("history")
    data object NewGame : Screen("new_game")
    data object FirstTime : Screen("first_time")
    data object SecondTime : Screen("second_time")
}