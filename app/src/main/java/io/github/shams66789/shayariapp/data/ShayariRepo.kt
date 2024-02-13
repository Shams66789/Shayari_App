package io.github.shams66789.shayariapp.data

import android.content.Context
import io.github.shams66789.shayariapp.data.data_models.AllShayari
import io.github.shams66789.shayariapp.data.data_models.AllShayariCategory

class ShayariRepo(context : Context) {

    lateinit var databse: ShayariDatabse

    init {
        databse = ShayariDatabse.DbBuilder(context)
    }
    fun getAllShayariCategory() : List<AllShayariCategory> {
        return databse.dao().getAllShayariCategory()
    }

    fun getAllShayari(cat_id : Int) : List<AllShayari> {
        return databse.dao().getShayari(cat_id)
    }
}