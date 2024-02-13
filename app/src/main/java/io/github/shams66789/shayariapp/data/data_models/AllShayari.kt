package io.github.shams66789.shayariapp.data.data_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AllShayari")
class AllShayari (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") var id : Int? = null,
    var Cat_id : Int?,
    var Shayari : String?
)