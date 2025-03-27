package com.pycreations.wordgame.navgraph

sealed class Route(val route : String) {
    object HomeScreenR : Route(route = "home_screen")
    object PlayBoardScreenR : Route(route = "play_board_screen")
    object SentenceFormBoard : Route(route = "sentence_form_board_scr")
    object SelectModeScr : Route(route = "select_mode_scr")
}