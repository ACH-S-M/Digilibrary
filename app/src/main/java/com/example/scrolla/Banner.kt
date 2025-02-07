package com.example.scrolla

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrolla.ui.theme.ScrollaTheme

@Composable
fun Banner() {
    Row(modifier = Modifier
        .fillMaxWidth(1f)){
        Image(painter = painterResource(id = R.drawable.display),
            contentDescription = "Display",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPrev() {
    ScrollaTheme {
        Banner()
    }
}