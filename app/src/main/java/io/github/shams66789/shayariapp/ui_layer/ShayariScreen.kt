package io.github.shams66789.shayariapp.ui_layer

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Whatsapp
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.shams66789.shayariapp.data.data_models.AllShayari

@Composable
fun ShayariScreen(allShayariList : List<AllShayari>) {
    var context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),

        topBar = {
            Card(
                modifier = Modifier
                    .height(56.dp),
                shape = CardDefaults.elevatedShape,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "All Shayari",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.White,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    )
//                    Icon(
//                        imageVector = Icons.Rounded.Settings,
//                        contentDescription = null,
//                        modifier = Modifier.size(24.dp),
//                        tint = Color.White
//                    )
                }
            }
        }) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .padding(top = 10.dp)) {
            items(allShayariList) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = it.Shayari.toString(),
                            textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(imageVector = Icons.Outlined.ContentCopy, contentDescription = null,
                                modifier = Modifier.clickable {
                                    val clipboardManager = context
                                        .getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                                    val clipData = ClipData.newPlainText("text", it.Shayari)
                                    clipboardManager.setPrimaryClip(clipData)
                                    Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
                                }
                            )
                            Icon(imageVector = Icons.Outlined.Whatsapp, contentDescription = null,
                                modifier = Modifier.clickable {
                                    val textToShare = it.Shayari
                                    val sendIntent = Intent(Intent.ACTION_SEND)
                                    sendIntent.type = "text/plain"
                                    sendIntent.setPackage("com.whatsapp")
                                    sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare)

                                    if (sendIntent.resolveActivity(context.packageManager) != null) {
                                        context.startActivity(sendIntent)
                                    } else {
                                        Toast.makeText(context, "WhatsApp is not installed", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            )
                            Icon(imageVector = Icons.Outlined.Share, contentDescription = null,
                                modifier = Modifier.clickable {
                                    val intent = Intent()
                                    intent.setAction(Intent.ACTION_SEND)
                                    intent.setType("text/plain")
                                    intent.putExtra(Intent.EXTRA_TEXT, it.Shayari.toString())
                                    context.startActivity(intent)
                                })
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}