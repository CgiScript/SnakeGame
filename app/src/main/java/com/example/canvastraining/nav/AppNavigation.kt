package com.example.canvastraining.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.canvastraining.DataStoreManager
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
fun AppNavigation(ctx:Context){

    val navController = rememberNavController()

    val dataStore = remember { DataStoreManager(ctx) }
    val gridSize = dataStore.gridSize.collectAsState(initial = 10f).value.toInt()
    val difficulty = dataStore.difficultyLevel.collectAsState(initial = 10f).value.toInt()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> { HomePage(
            {navController.navigate(Game)},
            {navController.navigate(HighScores)},
            {navController.navigate(Settings)}
        ) }
        composable<HighScores> { HighScoresPage() }
        composable<Settings> { SettingsPage(ctx = LocalContext.current) }
        composable<Game> { GameArea(gridSize, difficulty) }
    }
}