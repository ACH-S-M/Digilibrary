package com.example.scrolla

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.scrolla.ui.theme.digilysecondary
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    DoubleBackExit(navController = navController)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max)){
                 Column(modifier = Modifier
                     .fillMaxWidth()
                     .height(intrinsicSize = IntrinsicSize.Max)
                     .padding(start = 40.dp, top = 60.dp), verticalArrangement = Arrangement.Center) {
                     Image(painter = painterResource(id = R.drawable.elaina),
                         contentDescription = "Profile",
                         modifier = Modifier
                             .size(150.dp)
                             .clip(RoundedCornerShape(90.dp)),
                         contentScale = ContentScale.FillWidth
                     )
                     Text(
                         text = "Achaia.S.M",
                         color = colorPrimaryDigily,
                         modifier = Modifier.padding(top = 12.dp),
                         fontSize = 28.sp,
                         fontWeight = FontWeight.Bold,
                     )
                 }

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Edit Profil terbuka", Toast.LENGTH_SHORT)
                                .show()
                        },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Icon(imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit_Profile",modifier = Modifier.padding(start = 30.dp) )
                        Text(text = "Edit Profile", fontSize = 18.sp)

                    }
                    Divider(thickness = 2.dp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp), color = colorPrimaryDigily)
                }

                // Batas atas
                //Nav Menu
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max)) {
                    //Ini MASING MASING ROW BUAT KE MENU LAIN
                    DrawerMenuItem(icon = Icons.Filled.Send, text = "Kirim Novel") {
                        navController.navigate("drawer"){popUpTo(0)}
                        scope.launch { drawerState.close() }
                    }
                    DrawerMenuItem(icon = Icons.Filled.ThumbUp, text = "Populer") {
                        navController.navigate("drawer"){popUpTo(0)}
                        scope.launch { drawerState.close() }
                    }

                }
                //Setting Akun
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                    Divider(thickness = 2.dp, modifier = Modifier.fillMaxWidth(), color = colorPrimaryDigily)
                    DrawerMenuItem(icon = Icons.Filled.Settings, text = "Setting") {
                        navController.navigate("favorites")
                    }
                }

            }
        },
    ) {
        Scaffold(
            topBar = { TopMenuBar(drawerState = drawerState, scope = scope)},
            bottomBar = { BottomNavbar(navController) }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationGraph(navController = navController)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item { Banner() }
        item { CardRow() }
        item { CardColumn() }
        
    }
}



