package com.example.scrolla

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrolla.ui.theme.ScrollaTheme

@Composable
fun TopMenuBar(modifer:Modifier = Modifier) {
    val context = LocalContext.current
    Row(modifer.fillMaxWidth()
        .padding(0.dp,6.dp),
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
            IconButton(onClick = { Toast.makeText(context,"Membuka keranjang", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = null ,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = { Toast.makeText(context,"Membuka keranjang", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Sharp.Notifications,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopMenuBarPreview() {
    ScrollaTheme {
        TopMenuBar()
    }
}