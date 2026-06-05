package com.konyali.fitventure.services
import androidx.compose.runtime.mutableStateMapOf
import com.konyali.fitventure.models.Food
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

val grilledChicken = Food(name = "Izgara Tavuk", calorie = 165, protein = 31.0, carb = 0.0, fat = 3.6)
val basmatiRice = Food(name = "Basmati Pirinç", calorie = 130, protein = 2.7, carb = 28.0, fat = 0.3)
val wheyProtein = Food(name = "Whey", calorie = 110, protein = 25.0, carb = 2.0, fat = 1.5)
val quickOats = Food(name = "Yulaf", calorie = 389, protein = 16.9, carb = 66.3, fat = 6.9)

var dailyfoods = mutableStateMapOf<Food, Int>(
    grilledChicken to 250, // 250 gram tavuk
    basmatiRice to 200,    // 200 gram pirinç
    wheyProtein to 30,     // 30 gram (1 ölçek) whey
    quickOats to 100       // 100 gram yulaf
)

fun dailyfoodadd(food: Food, count: Int){
    if(food in dailyfoods.keys){
        dailyfoods[food] = (dailyfoods[food] ?: 0) + count
    } else{
        dailyfoods[food] = count
    }
    return
} //Eğer ki dailyfood listesinde zaten mevcut iste ekle / Yoksa oluştur

fun dailyfoodremove(food: Food, count: Int, delete: Boolean = false) {
    //delete default parameter, eğer ki komple sil true olarak call edilirse
    //komple listeden siler
    if (delete == true || ((dailyfoods[food] ?: 0) < count)) {
        dailyfoods.remove(food)
        return
    }   else {
        dailyfoods[food] = (dailyfoods[food] ?: 0) - count
        return
    }
}

fun dailySave(context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    // Map'i direkt JSON'a çevirir
    val json = Gson().toJson(dailyfoods)
    prefs.edit().putString("daily_foods_db", json).apply()
}

fun dailyLoad(context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val json = prefs.getString("daily_foods_db", null)
    if (!json.isNullOrEmpty()) {
        // Map<Food, Int> tipi için özel Token
        val type = object : TypeToken<Map<Food, Int>>() {}.type
        val storedMap: Map<Food, Int> = Gson().fromJson(json, type)
        dailyfoods.clear()
        dailyfoods.putAll(storedMap)
    }
}


