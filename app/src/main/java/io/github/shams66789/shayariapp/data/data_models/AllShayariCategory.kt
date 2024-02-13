package io.github.shams66789.shayariapp.data.data_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AllShayariCategory")
class AllShayariCategory (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") var id: Int? = null,
    var name : String?,
    @ColumnInfo(name = "id") var categoryId : Int?
)