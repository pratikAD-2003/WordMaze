package com.pycreations.wordgame.databse

import android.content.Context
import android.media.MediaPlayer
import com.pycreations.wordgame.R

object BackgroundMusicManager {
    private var mediaPlayer: MediaPlayer? = null
    private var isPaused = false

    fun startMusic(context: Context) {
        val prefs = context.getSharedPreferences(SharedPrefFunctions.MUSIC_DB, Context.MODE_PRIVATE)
        if (prefs.getBoolean(SharedPrefFunctions.MUSIC_DB, true)) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(context, R.raw.bkg_music_m1).apply {
                    isLooping = true
                    start()
                }
            } else if (isPaused) {
                mediaPlayer?.start()
                isPaused = false
            }
        }
    }

    fun stopMusic(context: Context) {
            mediaPlayer?.release()
            mediaPlayer = null
    }

    fun pauseMusic() {
        mediaPlayer?.pause()
        isPaused = true
    }

    fun resumeMusic() {
        if (isPaused) {
            mediaPlayer?.start()
            isPaused = false
        }
    }
}
