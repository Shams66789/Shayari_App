package io.github.shams66789.shayariapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.shams66789.shayariapp.data.dao.Dao
import io.github.shams66789.shayariapp.data.data_models.AllShayari
import io.github.shams66789.shayariapp.data.data_models.AllShayariCategory

@Database(entities = arrayOf(AllShayariCategory::class,
    AllShayari::class),
    version = 3, exportSchema = false)
abstract class ShayariDatabse : RoomDatabase(){

    abstract fun dao() : Dao

    companion object{
        fun DbBuilder(context: Context) : ShayariDatabse {
            return Room.databaseBuilder(context,ShayariDatabse::class.java, "Shayari.db")
                .fallbackToDestructiveMigration().allowMainThreadQueries()
                .createFromAsset("Shayari.db").build()
        }
    }
}