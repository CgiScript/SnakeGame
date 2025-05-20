package com.example.canvastraining.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.canvastraining.game.GameArea
import com.example.canvastraining.ui.highscores.HighScoresPage
import com.example.canvastraining.ui.home.HomePage
import com.example.canvastraining.ui.settings.SettingsPage
import kotlinx.serialization.Serializable

@Serializable object Home
@Serializable object HighScores
@Serializable object Settings
@Serializable object Game

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> { HomePage(
            {navController.navigate(Game)},
            {navController.navigate(HighScores)},
            {navController.navigate(Settings)}
        ) }
        composable<HighScores> { HighScoresPage() }
        composable<Settings> { SettingsPage() }
        composable<Game> { GameArea() }
    }
}