package com.example.scrolla

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scrolla.ui.theme.ContentDigily
import com.example.scrolla.ui.theme.Favorite
import com.example.scrolla.ui.theme.ScrollaTheme
import com.example.scrolla.ui.theme.colorPrimaryDigily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BottomNavbar(navController: NavController,modifier:Modifier = Modifier) {
    val currentDestination = navController.currentBackStackEntry?.destination
    Log.d("NavDebug", "Current destination: ${currentDestination?.route}")

    Row(
        modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement =Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        )
    {
               Column(
                   modifier
                       .width(IntrinsicSize.Max)
                       .clickable { navController.navigate("home") { popUpTo(0) } }, horizontalAlignment = Alignment.CenterHorizontally) {
                   Icon(imageVector = Icons.Filled.Home,
                       contentDescription = "Home",
                       modifier.size(30.dp))
                   Text(text = "Home")
               }
                Column(
                    modifier
                        .width(IntrinsicSize.Max)
                        .clickable { navController.navigate("search") { popUpTo(0) } }, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        modifier.size(30.dp))
                    Text(text = "Search")
                }
                Column(
                    modifier
                        .width(IntrinsicSize.Max)
                        .clickable { navController.navigate("favorites") { popUpTo(0) } }, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        modifier.size(30.dp))
                    Text(text = "Favorites", textAlign = TextAlign.Center)
                }
    }
}
@Composable
fun NavigationGraph(navController: NavHostController,modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable("search") { ContentDigily(navController) }
        composable("favorites") { Favorite(navController) }
        composable("drawer"){ ContentDigily(navController)}
        composable("notification") { NotifPage(navController) }
        composable("cart") { Cart(navController) }
    }
}

@Composable
fun DoubleBackExit(navController: NavController) {
    var backPressedOnce by remember { mutableStateOf(false) }
    val context = LocalContext.current
    BackHandler {
        if (backPressedOnce) {
            (context as? Activity)?.finish()
        } else {
            backPressedOnce = true
            Toast.makeText(context, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000)
                backPressedOnce = false
            }
        }
    }
}
// drawer Menu Item
@Composable
fun DrawerMenuItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 8.dp)
            .clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier
                .padding(start = 30.dp)
                .size(30.dp)
        )
        Text(
            text = text,
            color = colorPrimaryDigily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavbarPrev() {
    ScrollaTheme {
        BottomNavbar(rememberNavController())
    }

}
