package com.pycreations.wordgame.databse

import android.content.Context

object SharedPrefFunctions {
    val MUSIC_DB = "check_music"
    val SOUND_DB = "check_sound"
    val VIBRATE_DB = "check_vibrate"
    val LEVEL_DB = "check_level54"
    val LEVEL_KEY = "current_level4"
    val FDHJKH_DFDF = "fjdkfjsk_fdfksdfnk"
    val FDFDF_KEY = "fdfdfs_key"

    val LEVEL_DB_SEN = "level_db_sen_fdkfdsfs"
    val LEVEL_KEY_SENTENCE = "level_key_sentence"
    val JFDFDF_FDF_SEN = "sen_fdkjfdfks"
    val FDFDF_SEN_KEY = "fadsfsfd_key"

    fun toggleMusic(context: Context) {
        val musicPref = context.getSharedPreferences(MUSIC_DB, Context.MODE_PRIVATE)
        val editor = musicPref.edit()
        if (musicPref.getBoolean(MUSIC_DB, true)) {
            editor.putBoolean(MUSIC_DB, false);
        } else {
            editor.putBoolean(MUSIC_DB, true);
        }
        editor.apply()
    }

    fun toggleSound(context: Context) {
        val musicPref = context.getSharedPreferences(SOUND_DB, Context.MODE_PRIVATE)
        val editor = musicPref.edit()
        if (musicPref.getBoolean(SOUND_DB, true)) {
            editor.putBoolean(SOUND_DB, false);
        } else {
            editor.putBoolean(SOUND_DB, true);
        }
        editor.apply()
    }

    fun toggleVibrate(context: Context) {
        val musicPref = context.getSharedPreferences(VIBRATE_DB, Context.MODE_PRIVATE)
        val editor = musicPref.edit()
        if (musicPref.getBoolean(VIBRATE_DB, true)) {
            editor.putBoolean(VIBRATE_DB, false);
        } else {
            editor.putBoolean(VIBRATE_DB, true);
        }
        editor.apply()
    }

    fun updateLevelWordFormation(context: Context) {
        val levelPref = context.getSharedPreferences(LEVEL_DB, Context.MODE_PRIVATE)
        val editor = levelPref.edit()
        editor.putInt(LEVEL_KEY, levelPref.getInt(LEVEL_KEY, 0) + 1);
        editor.apply()
        updateLevelCoin(context, getCurrentLevelWordFormation(context));
    }

    fun getCurrentLevelWordFormation(context: Context): Int {
        val levelPref = context.getSharedPreferences(LEVEL_DB, Context.MODE_PRIVATE)
        return levelPref.getInt(LEVEL_KEY, 0)
    }

    private fun updateLevelCoin(context: Context, currentLevel: Int) {
        val levelPref = context.getSharedPreferences(FDHJKH_DFDF, Context.MODE_PRIVATE)
        val editor = levelPref.edit()
        if (currentLevel < 50) {
            editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) + 10);
        } else if (currentLevel < 100) {
            editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) + 15);
        } else if (currentLevel < 150) {
            editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) + 20);
        } else if (currentLevel < 200) {
            editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) + 25);
        } else {
            editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) + 30);
        }
        editor.apply()
    }

    fun getCoins(context: Context): Int {
        val levelPref = context.getSharedPreferences(FDHJKH_DFDF, Context.MODE_PRIVATE)
        return levelPref.getInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100));
    }

    fun subtractCoins(context: Context, coinToSub: Int) {
        val levelPref = context.getSharedPreferences(FDHJKH_DFDF, Context.MODE_PRIVATE)
        val editor = levelPref.edit()
        editor.putInt(FDFDF_KEY, levelPref.getInt(FDFDF_KEY, 100) - coinToSub);
        editor.apply()
    }

    fun getCurrentLevelWordSentence(context: Context): Int {
        val levelPref = context.getSharedPreferences(LEVEL_DB_SEN, Context.MODE_PRIVATE)
        return levelPref.getInt(LEVEL_KEY_SENTENCE, 0)
    }

    fun updateLevelWordSentence(context: Context) {
        val levelPref = context.getSharedPreferences(LEVEL_DB_SEN, Context.MODE_PRIVATE)
        val editor = levelPref.edit()
        editor.putInt(LEVEL_KEY_SENTENCE, levelPref.getInt(LEVEL_KEY_SENTENCE, 0) + 1);
        editor.apply()
        updateLevelCoin(context, getCurrentLevelWordSentence(context));
    }

}