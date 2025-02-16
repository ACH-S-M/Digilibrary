package com.example.percobaanke5jetpackcompose.com.example.scrolla

import  android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrolla.R
import com.example.scrolla.ui.theme.ScrollaTheme

class Detail_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageResId = intent.getIntExtra("IMAGE", 0)
        val name = intent.getStringExtra("NAME")
        val price = intent.getStringExtra("PRICE")
        setContent {
            ScrollaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookDetailScreen(
                        ImgRes = imageResId,
                        Name = name ?: "Unknown",
                        Price = price ?: "Rp. 0"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Detail_Book() {
    BookDetailScreen(R.drawable.dragonpearl,"Lorem Ipsum DOLOR SIT AMET CONSTRUC","RP.2000.000,00")
}


@Composable
fun BookDetailScreen(ImgRes: Int, Name: String, Price: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1F44))
    ) {
        TopAppBar()
        BookContent(ImgRes, Name, Price)
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(80.dp)
            )

        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share",
                tint = Color.White,
                modifier = Modifier
                    .size(80.dp)
            )
        }
    }
}

@Composable
fun BookContent(ImgRes: Int, Name: String, Price: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF00214D), Color.White, Color.White, Color.White)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Image(
            painter = painterResource(ImgRes),
            contentDescription = "Book Cover",
            modifier = Modifier
                .height(200.dp)
                .width(140.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = Name, fontSize = 22.sp, fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .width(340.dp)
                .offset(x = 8.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Stephanie Garber", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        PriceSection(Price)
        Spacer(modifier = Modifier.height(16.dp))
        SynopsisSection()
        Spacer(modifier = Modifier.height(16.dp))
        BookInfo()
    }
}

@Composable
fun PriceSection(Price: String) {
    var context: Context = LocalContext.current
    val colorPrimary = Color(0xFF00214D)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Berhasil dibeli buku dengan Harga $Price",
                    Toast.LENGTH_SHORT
                ).show()
            }, modifier = Modifier
                .width(240.dp)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00214D)
            )
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Buy",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = Price, fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.width(2.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00214D)
            ),
            modifier = Modifier
                .padding(12.dp)
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Add To Cart",
                tint = Color.White,
                modifier = Modifier
                    .height(40.dp)
                    .width(20.dp)
            )
        }


    }
}


@Composable
fun SynopsisSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 12.dp),
    ) {
        Text(text = "Synopsis", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Once upon a time, there were two close friends who were walking through the forest together...",
            fontSize = 14.sp, color = Color.Black
        )
    }
}

@Composable
fun BookInfo() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Genre", fontSize = 14.sp, color = Color.Black)
            Text(text = "Romance, Comedy, Journey", fontSize = 12.sp, color = Color.Black)
        }
        Divider(modifier = Modifier.width(2.dp).height(40.dp), color = Color.Black)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "50", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "Chapters", fontSize = 12.sp, color = Color.Black)
        }
        Divider(modifier = Modifier.width(2.dp).height(40.dp), color = Color.Black)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "4.5★", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "80 Reviews", fontSize = 12.sp, color = Color.Black)
        }
    }
}
