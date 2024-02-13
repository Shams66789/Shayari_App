package io.github.shams66789.shayariapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.shams66789.shayariapp.data.data_models.AllShayari
import io.github.shams66789.shayariapp.data.data_models.AllShayariCategory

@Dao
interface Dao {

    @Query("SELECT * FROM AllShayariCategory")
    fun getAllShayariCategory() : List<AllShayariCategory>

    @Query("SELECT * FROM AllShayari WHERE Cat_id = :cat_id")
    fun getShayari(cat_id : Int) : List<AllShayari>
}