package com.seongju.oliveyoungclone.presentation.util

sealed class Screen(val route: String) {

    object SplashScreen: Screen("splash_screen")

}