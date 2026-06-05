package com.konyali.fitventure.services
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import com.konyali.fitventure.models.Food
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

var localfoods = mutableStateListOf<Food>()

fun localsave(context: Context){
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val json = Gson().toJson(localfoods.toList()) // Listeye çevirip kaydet
    prefs.edit().putString("foods_localdb", json).apply()
}

fun localload(context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val json = prefs.getString("foods_localdb", null)
    if (!json.isNullOrEmpty()) {
        val type = object : TypeToken<List<Food>>() {}.type
        val items: List<Food> = Gson().fromJson(json, type)
        localfoods.clear()
        localfoods.addAll(items)
    }
}



