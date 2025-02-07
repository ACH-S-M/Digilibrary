package com.example.scrolla

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.percobaanke5jetpackcompose.com.example.scrolla.Detail_Activity
import com.example.scrolla.ui.theme.Purple40
import com.example.scrolla.ui.theme.ScrollaTheme
import com.example.scrolla.ui.theme.colorPrimaryDigily
import com.example.scrolladata.Datacards

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ScrollaTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyApp() {
    Layout()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Layout() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = {
               Row(modifier = Modifier
                   .fillMaxWidth(),
                   Arrangement.SpaceBetween,
                   Alignment.CenterVertically,
               ) {
                   IconButton(onClick = {
                       Toast.makeText(context, "Menu drawable kebuka", Toast.LENGTH_SHORT).show()
                   },) {
                     Icon(imageVector = Icons.Filled.Menu, contentDescription = null,
                         tint = MaterialTheme.colorScheme.onBackground,
                         modifier = Modifier.size(50.dp))

                   }
                    Row(modifier = Modifier.padding(start = 12.dp ,end = 12.dp)){
                        IconButton(onClick = { Toast.makeText(context,"Membuka keranjang",Toast.LENGTH_SHORT).show()}) {
                          Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = null ,
                              tint = MaterialTheme.colorScheme.onBackground,
                               modifier = Modifier.size(30.dp)
                              )
                        }
                        IconButton(onClick = { Toast.makeText(context,"Membuka keranjang",Toast.LENGTH_SHORT).show()}) {
                            Icon(imageVector = Icons.Sharp.Notifications,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
               }
            })
        },
        bottomBar = {
            BottomAppBar {
               Column(horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center,
                   modifier = Modifier .fillMaxSize()){
                   Text(text = "Home")
               }
            }

        }


    ){
        paddingValues -> LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()) { item{
                         Row(modifier = Modifier
                             .fillMaxWidth()){
                             Image(painter = painterResource(id = R.drawable.display),
                                 contentDescription = "Display",
                                 modifier = Modifier
                                     .fillMaxSize()
                                     .padding(0.dp)
                                     .height(300.dp)
                                     .offset(y = -32.dp),
                                 contentScale = ContentScale.FillWidth
                             )
                         }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .offset(y=-40.dp)) {
                        Text(text = "Buku Terpopuler",
                            Modifier.padding(start = 20.dp),
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground)
                        CardRow()

                    }

            }

        }

    }
}
@Preview
@Composable
fun CardRow() {
    var context = LocalContext.current
    var datacard = remember{ getlist(context) }
    var colorPrimary = Color(0x4004FF00)
    val intent = Intent(context, Detail_Activity::class.java)
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        LazyRow() {
            itemsIndexed(datacard){index, data ->
                ElevatedCard(
                    modifier = Modifier
                        .width(250.dp)
                        .height(300.dp)
                        .padding(end = 20.dp)
                        .clickable {
                            intent.putExtra("IMAGE", data.img ?: 0)
                            intent.putExtra("NAME", data.nama ?: "null")
                            intent.putExtra("PRICE", data.harga ?: "null")
                            context.startActivity(intent)
                        },
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    )) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorPrimary),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(data.img),
                            contentDescription = null,
                            modifier = Modifier
                                .size(160.dp)
                                .padding(0.dp, 6.dp)
                        )

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp, 20.dp)
                    ) {
                        Text(text = data.nama, modifier = Modifier.padding(12.dp, 0.dp))
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = data.harga,
                            Modifier.padding(12.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }


                }

            }
        }

    }
}

fun getlist(context:Context):List<Datacards>{
        var ImgList = context.resources.obtainTypedArray(R.array.Image_Book)
        var NameBook = context.resources.getStringArray(R.array.Name_Book)
        var PriceBook = context.resources.getStringArray(R.array.Price_Book)
        var listdata= mutableListOf<Datacards>()
        for (i in NameBook.indices){
            listdata.add(
                Datacards(
                    ImgList.getResourceId(i,0),
                    NameBook[i],
                    PriceBook[i]
                )
            )
        }
        ImgList.recycle()
        return listdata
    }
