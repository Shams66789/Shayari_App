package io.github.shams66789.shayariapp.ui_layer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.rounded.KeyboardDoubleArrowRight
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CategoryScreen(navController: NavController, viewModel: ShayariViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
        ,

        topBar = {
        Card(
            modifier = Modifier
                .height(50.dp),
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(
                containerColor = Color.Red
            )
            ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shayari Category",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                        )
                )
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }
        }
    }) {
            LazyColumn(modifier = Modifier
                .padding(it)
                .padding(top = 10.dp)) {
                items(viewModel.shayariCategoryList) {
                    Box(
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(50.dp)
                            )

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                                .background(Color.Transparent)
                                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                                .clickable {
                                           navController.navigate("ShayariScreen" + "/${it.id}")
                                },
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Outlined.Book, contentDescription = null,
                                modifier = Modifier.padding(start = 8.dp))
                            Text(text = it.name.toString())
                            Icon(imageVector = Icons.Rounded.KeyboardDoubleArrowRight, contentDescription = null,
                                modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
    }

}