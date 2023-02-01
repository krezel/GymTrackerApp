package com.example.gymtracker

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromlist(tr:ArrayList<String>) : String{
        var string = ""
        for (ex in tr){
            string = "$ex,"
        }
        return string
    }
    @TypeConverter
    fun toList(tr:String) : ArrayList<String>{
        val list = arrayListOf<String>()
        for (w in tr.trim(' ').split(","))
            if (w.isNotEmpty())
                list.add(w)
        return list
    }
}