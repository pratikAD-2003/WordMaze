package com.pycreations.wordgame.databse

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import com.pycreations.wordgame.R

class SoundManager(context: Context) {
    private val soundPool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
    private val tapSound = soundPool.load(context, R.raw.tap_sound, 1)
    private val levelCompleteSound = soundPool.load(context, R.raw.level_c, 1)
    private val prefs = context.getSharedPreferences(SharedPrefFunctions.SOUND_DB, Context.MODE_PRIVATE)

    fun playTapSound() {
        if (prefs.getBoolean(SharedPrefFunctions.SOUND_DB, true)) {
            soundPool.play(tapSound, 1f, 1f, 1, 0, 1f)
        }
    }

    fun playLevelCompleteSound() {
        if (prefs.getBoolean(SharedPrefFunctions.SOUND_DB, true)) {
            soundPool.play(levelCompleteSound, 1f, 1f, 1, 0, 1f)
        }
    }
}

