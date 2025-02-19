package com.example.scrolla

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.scrolla.ui.theme.ScrollaTheme
import com.example.scrolla.ui.theme.colorPrimaryDigily

class Cart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cart(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Cart(navController: NavController, modifier: Modifier = Modifier,) {
    Column(modifier.fillMaxSize()) {
        Icon(imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            modifier
                .size(80.dp)
                .padding(vertical = 20.dp), tint = colorPrimaryDigily )
        Divider(
            modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), thickness = 2.dp)
       LazyColumn {
           items(7) {
               CardItem(imgRes = painterResource(id = R.drawable.dragonpearl), title = "Dragon pearl" , Price = "IDR 20000" )
           }
       }

    }

}

//@Preview(showBackground = true)
@Composable
fun CartPrev() {
    ScrollaTheme {
        Cart(navController = rememberNavController())
    }
}

@Composable
fun CardItem(modifier:Modifier = Modifier,
             imgRes: Painter,
             title:String,
             Price:String
) {
    val Context = LocalContext.current
    var isChecked = remember { mutableStateOf(false) }
    Row(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(intrinsicSize = IntrinsicSize.Max)
            .clickable {
                Toast
                    .makeText(
                        Context,
                        "Kamu masuk Ke detail Buku (make intent)",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }, verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp))
    {
        Checkbox(checked = isChecked.value,
            onCheckedChange = {isChecked.value = it} )
        Box(
            modifier
                .size(120.dp)
                .background(Color.Transparent)
                .border(
                    2.dp,
                    Color.DarkGray,
                    shape = RoundedCornerShape(9.dp)
                )
                .padding(4.dp)) {
            Image(painter = imgRes, contentDescription = "Book",modifier.fillMaxSize())
        }
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 8.dp), verticalArrangement = Arrangement.SpaceAround) {
            Text(text = title,color = colorPrimaryDigily, fontSize = 16.sp)
            Text(text = Price, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    ScrollaTheme {
        Column {
            CardItem(imgRes = painterResource(id = R.drawable.dragonpearl), title = "Dragon pearl" , Price = "IDR 20000" )
        }
    }
}

@Composable
fun Total(modifier: Modifier = Modifier) {
    var ischeck = false
  Row(
      modifier
          .fillMaxWidth()
          .padding(12.dp)
          .height(80.dp)
          .border(width = 2.dp, colorPrimaryDigily, RoundedCornerShape(80.dp))
          .background(color = Color.White ,shape = RoundedCornerShape(80.dp))
          , verticalAlignment = Alignment.CenterVertically) {
     Row(
         modifier
             .width(IntrinsicSize.Max)
             .fillMaxHeight()
             .padding(start = 20.dp), verticalAlignment = Alignment.CenterVertically) {
         Checkbox(checked = ischeck, onCheckedChange = { ischeck = it })
         Text(text = "Semua ", fontWeight = FontWeight.Light, color = colorPrimaryDigily)
     }
      Column(modifier = Modifier
          .width(intrinsicSize = IntrinsicSize.Max)

          .fillMaxHeight()
          .padding(start = 20.dp), verticalArrangement = Arrangement.Center) {
          Text(text = "Total", fontWeight = FontWeight.Light)
          Text(text = "", fontWeight = FontWeight.Light)
      }
      Row(modifier.fillMaxWidth()
          .padding(start = 8.dp )
          .background(color = colorPrimaryDigily)
          .height(80.dp), verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center) {
          Text(text = "CheckOut",color = Color.White)
      }
  }
}

@Preview(showBackground = true)
@Composable
fun TotalPrev() {
    ScrollaTheme {
        Total()
    }
}