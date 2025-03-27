package com.pycreations.wordgame.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pycreations.wordgame.presentation.HomeScr
import com.pycreations.wordgame.presentation.PlayBoardScr
import com.pycreations.wordgame.presentation.SelectModeScr
import com.pycreations.wordgame.presentation.SentenceFormPlayBoard

@Composable
fun NavGraph() {
    val context = LocalContext.current
    val navHostController: NavHostController = rememberNavController()

    NavHost(navHostController, startDestination = Route.HomeScreenR.route) {
        composable(Route.HomeScreenR.route) {
            HomeScr(navHostController,context)
        }
        composable(Route.PlayBoardScreenR.route) {
            PlayBoardScr(navHostController,context)
        }
        composable(Route.SentenceFormBoard.route){
            SentenceFormPlayBoard(context,navHostController)
        }
        composable(Route.SelectModeScr.route){
            SelectModeScr(context,navHostController)
        }
    }
}