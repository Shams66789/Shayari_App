package io.github.shams66789.shayariapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.shams66789.shayariapp.ui.theme.ShayariAppTheme
import io.github.shams66789.shayariapp.ui_layer.CategoryScreen
import io.github.shams66789.shayariapp.ui_layer.ShayariScreen
import io.github.shams66789.shayariapp.ui_layer.ShayariViewModel

class MainActivity : ComponentActivity() {
    lateinit var viewModel : ShayariViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this@MainActivity).get(ShayariViewModel::class.java)
//        enableEdgeToEdge()
        setContent {
            ShayariAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    MyApp(paddingValues = innerPadding, viewModel)
                }
            }
        }
    }
}
@Composable
fun MyApp(paddingValues: PaddingValues, viewModel: ShayariViewModel) {
    Box(modifier = Modifier.padding(paddingValues)) {
//        CategoryScreen()
        var navController = rememberNavController()
        NavHost(navController = navController, startDestination = "CategoryScreen" ) {
            composable(route = "CategoryScreen") {
                CategoryScreen(navController, viewModel )
            }

            composable(route = "ShayariScreen" + "/{id}") {
                val id = it.arguments?.getString("id")

                ShayariScreen(viewModel.getShayariByCategory(id!!.toInt()))
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShayariAppTheme {
        Greeting("Android")
    }
}