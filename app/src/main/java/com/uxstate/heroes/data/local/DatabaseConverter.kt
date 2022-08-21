package com.uxstate.heroes.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    //list to ROOM String
    @TypeConverter
    fun listToRoomString(list: List<String>): String{

        return list.joinToString(separator = ",")
    }

           // ROOM String to list

    @TypeConverter
    fun roomStringToList(roomString: String):List<String>{

        return roomString.split( ",").map {

            it
        }
    }
}