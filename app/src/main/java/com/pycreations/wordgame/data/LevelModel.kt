package com.pycreations.wordgame.data

data class LevelModel(
    val levelNumber: Int,
    var givenCharacters: List<Char>,  // Letters available
    val targetWords: List<String>,    // Valid words to form
    val noOfInputFields: Int          // Fields to input words
)
