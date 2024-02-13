package io.github.shams66789.shayariapp.ui_layer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.github.shams66789.shayariapp.data.ShayariRepo
import io.github.shams66789.shayariapp.data.data_models.AllShayari
import io.github.shams66789.shayariapp.data.data_models.AllShayariCategory

class ShayariViewModel(application: Application) : AndroidViewModel(application) {

    var shayariRepo : ShayariRepo

    var shayariCategoryList = mutableListOf<AllShayariCategory>()

    init {
        shayariRepo = ShayariRepo(application)
        shayariCategoryList.addAll(shayariRepo.getAllShayariCategory())
    }

    fun getShayariByCategory(cat_id : Int) : List<AllShayari>{
        return shayariRepo.getAllShayari(cat_id = cat_id)
    }
}