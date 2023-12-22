package com.dicoding.foodinfo.ui.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Welcome : Routes("welcome")
    object Login : Routes("login")
    object Register : Routes("register")
    object History : Routes("history")
    object Details : Routes("details")
    object AboutUs : Routes("about")
}