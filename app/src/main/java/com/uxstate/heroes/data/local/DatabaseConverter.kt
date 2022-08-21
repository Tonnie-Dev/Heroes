package com.uxstate.heroes.data.local

import androidx.room.TypeConverter

class DatabaseConverter {


    private val separator = ","
    //list to ROOM String
    @TypeConverter
    fun convertListToString(list: List<String>): String{

        return list.joinToString(separator = separator)
    }

           // ROOM String to list

    @TypeConverter
    fun roomStringToList(roomString: String):List<String>{

        return roomString.split( ",").map {

            it
        }
    }
}