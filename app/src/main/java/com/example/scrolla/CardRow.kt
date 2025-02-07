package com.example.scrolla

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.percobaanke5jetpackcompose.com.example.scrolla.Detail_Activity
import com.example.scrolladata.Datacards

fun getlist(context: Context):List<Datacards>{
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


@Preview
@Composable
fun CardRow(modifier: Modifier = Modifier) {
    var context = LocalContext.current
    var datacard = remember{ getlist(context) }
    var colorPrimary = Color(0x4004FF00)
    val intent = Intent(context, Detail_Activity::class.java)
    Column(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(8.dp)) {
        Text(text = "Buku Terpopuler",modifier.padding(0.dp,12.dp), fontSize = 24.sp)
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