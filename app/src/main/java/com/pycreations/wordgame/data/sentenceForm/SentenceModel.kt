package com.pycreations.wordgame.data.sentenceForm

data class SentenceModel(
    val levelNumber: String,
    val givenCharacters: List<String>,
    val targetWord: String,
    val sentence: String
)
