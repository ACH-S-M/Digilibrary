package com.example.scrolla

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.scrolla.ui.theme.ScrollaTheme
import kotlinx.coroutines.delay

class Splashscreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(Unit) {
                            delay(3000)

                            val intent = Intent(this@Splashscreen,MainActivity::class.java)
                            startActivity(intent)
                        }
                }

                }
            }
        }
    }


@Preview
@Composable
fun Splashscreenloading() {
  Box(modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
      ){
      Image(painter = painterResource(id = R.drawable.splashscreen),
          contentDescription = stringResource(
          id = R.string.Splashscreen),
          modifier = Modifier
              .fillMaxSize())

  }
}

data class Datacard(var img:Int,var nama:String,var harga:String)