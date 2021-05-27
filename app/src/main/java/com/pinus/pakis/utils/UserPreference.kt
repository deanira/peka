package com.pinus.pakis.utils

import android.content.Context
import androidx.core.content.edit
import com.pinus.pakis.model.OrangTua

internal class UserPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val UID = "uid"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(user: OrangTua) {
        preferences.edit {
            putString(NAME, user.nama)
            putString(EMAIL, user.email)
            putString(UID, user.id)
        }
    }

    fun getUser(): OrangTua {
        val model = OrangTua()
        model.nama = preferences.getString(NAME, "").toString()
        model.email = preferences.getString(EMAIL, "").toString()
        model.id = preferences.getString(UID, "").toString()

        return model
    }
}