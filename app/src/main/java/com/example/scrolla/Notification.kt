package com.example.scrolla

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.scrolla.ui.theme.ScrollaTheme
import com.example.scrolla.ui.theme.colorPrimaryDigily

class Notification : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun NotificationLayout(modifier:Modifier=Modifier,
                       title:String,
                       content:String) {
    val context = LocalContext.current
    Row(
        modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(intrinsicSize = IntrinsicSize.Max)
            .clickable {
                Toast
                    .makeText(context, "$title memberitahukan tentang $content", Toast.LENGTH_SHORT)
                    .show()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Image(painter = painterResource(id = R.drawable.logodigily),
            contentDescription = "Logo-Notif",
            modifier
                .size(60.dp)
                .padding(start = 5.dp))
        Column {
            Text(text = title,
                color = colorPrimaryDigily,
                fontSize = 20.sp)
            Text(
                text = content,
                color = colorPrimaryDigily,
                fontSize = 12.sp,)
        }

    }
}
@Preview(showBackground = true)
@Composable
fun NotifPrevLayout() {
    NotificationLayout(title = "Digily . CO", content = "Holla, Digilibers! Wellcome to DigiLibrary. Let’s ...")
}
@Composable
fun NotifPage(navController: NavController) {
    ScrollaTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            NotificationLayout(title = "Digily . CO", content = "Holla, Digilibers! Wellcome to DigiLibrary. Let’s ...")
            NotificationLayout(title = "Ihsan.Dev", content = "Tas tas apa yang isinya makanan ...")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NotifPagePrev() {
    ScrollaTheme {
        NotifPage(navController = rememberNavController())
    }
}

