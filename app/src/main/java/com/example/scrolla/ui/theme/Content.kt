package com.example.scrolla.ui.theme

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContentDigily(navController: NavController,modifier:Modifier = Modifier) {
   LazyColumn(modifier.fillMaxSize()){
       items(100){ index ->
            Text(text = "Ini adalah Search Ke $index")
       }
   }
}

@Preview(showBackground = true)
@Composable
fun ContentDigilyPrev() {
    ScrollaTheme {
        ContentDigily(rememberNavController())
    }
}
@Composable
fun Favorite(navController: NavController,modifier:Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize()){
        items(100){Index ->
            Text(text = "Ini adalah favorite ke $Index")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePrev() {
    ScrollaTheme {
        Favorite(rememberNavController())
    }
}