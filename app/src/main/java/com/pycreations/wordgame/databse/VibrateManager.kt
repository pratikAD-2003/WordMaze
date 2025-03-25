package com.pycreations.wordgame.databse

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import com.pycreations.wordgame.databse.SharedPrefFunctions.VIBRATE_DB

object VibrateManager {
    fun vibrateDevice(context: Context) {
        val musicPref = context.getSharedPreferences(VIBRATE_DB, Context.MODE_PRIVATE)

        if (musicPref.getBoolean(SharedPrefFunctions.VIBRATE_DB, true)) {
            val duration = 100L
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        duration,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(duration)
            }
        }
    }
}