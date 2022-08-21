package com.uxstate.heroes.data.local

import androidx.room.TypeConverter

class DatabaseConverter {
/* using "," as a separator may be bad if you happen to have  comma
character - "," - in your list.*/

    private val separator = ","
    //list to ROOM String
    @TypeConverter
    fun convertListToString(list: List<String>): String{

        return list.joinToString(separator = separator)
    }

           // ROOM String to list

    @TypeConverter
    fun convertStringToList(roomString: String):List<String>{

        return roomString.split( separator)
    }
}