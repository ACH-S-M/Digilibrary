package com.example.scrolla.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.scrolla.R

@Composable
fun ContentDigily(navController: NavController,modifier:Modifier = Modifier) {
    val context = LocalContext.current
    val listnya = remember { categoryList(context) }
    Column(modifier = Modifier.fillMaxSize()) {
        SearchPage()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(listnya) { category ->
                Category(category)
            }
        }
    }
}

@Composable
fun SearchPage(modifier: Modifier = Modifier) {
  SearchBarWriter()
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

@Composable
fun Category(listcategory: CategoryItem) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = listcategory.backgroundColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = listcategory.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = listcategory.subtitle,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
            Image(
                painter = painterResource(id = listcategory.imageRes),
                contentDescription = listcategory.title,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun SearchBarWriter(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val categories = listOf("All Collections", "Recomendations", "Best Seller")
    val textsearch = remember { mutableStateOf("") }
    Row(modifier.padding(16.dp, 24.dp), horizontalArrangement = Arrangement.spacedBy(26.dp), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(value = textsearch.value,
            onValueChange = { textsearch.value = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            placeholder = { Text(text = "Search Tittle Or Writer") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = digilysecondary,
                focusedContainerColor = OnfocusChange

            ),
            shape = RoundedCornerShape(60.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
            }
        )
        IconButton(onClick = { Toast.makeText(context,"Kategori dibuka",Toast.LENGTH_SHORT).show() },
            modifier
                .size(50.dp)
                .clip(
                    RoundedCornerShape(2.dp)
                )) {
            Image(
                painter = painterResource(id = R.drawable.categories),
                contentDescription = "Custom Icon",modifier.size(40.dp)
            )

        }
    }

    Row(
        modifier = Modifier.padding(bottom = 20.dp, start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        categories.forEach {
            Card(colors = CardDefaults.cardColors(containerColor = digilysecondary)) {
                Text(text = it, modifier = Modifier.padding(8.dp), fontSize = 12.sp)
            }
        }
    }

}
fun categoryList(context:Context):List<CategoryItem>{
    val titles = context.resources.getStringArray(R.array.Tittle_Book)
    val subtitles = context.resources.getStringArray(R.array.Subtittle_book)
    val backgroundColors = listOf(
        ContextCompat.getColor(context ,R.color.romanceColor),
        ContextCompat.getColor(context,R.color.black),
        ContextCompat.getColor(context,R.color.fictionColor),
        ContextCompat.getColor(context,R.color.scifiColor)
    ).map { Color(it) }
    val genreImage = context.resources.obtainTypedArray(R.array.Card_genre)

    val listCategories = mutableListOf<CategoryItem>().apply {
        for (i in titles.indices) {
            add(
                CategoryItem(
                    title = titles[i],
                    subtitle = subtitles.getOrNull(i) ?: "0 buku",
                    backgroundColor = backgroundColors.getOrNull(i) ?: Color.Gray,
                    imageRes = genreImage.getResourceId(i,R.drawable.wondurus)

                )
            )
        }
    }
    genreImage.recycle()
    return listCategories
}

data class CategoryItem(val title: String, val subtitle: String,val backgroundColor: Color, val imageRes: Int)