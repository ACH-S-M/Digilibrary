package com.example.scrolla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopMenuBar(modifer:Modifier = Modifier,drawerState: DrawerState,scope: CoroutineScope,navcontroller: NavController) {
    val context = LocalContext.current
    Row(
        modifer
            .fillMaxWidth()
            .padding(0.dp, 6.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            scope.launch { drawerState.open() }
        },) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(50.dp))

        }
        Row(modifier = Modifier.padding(start = 12.dp ,end = 12.dp)){
            IconButton(onClick = { navcontroller.navigate("cart")}) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = null ,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = { navcontroller.navigate("notification")}) {
                Icon(imageVector = Icons.Sharp.Notifications,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
