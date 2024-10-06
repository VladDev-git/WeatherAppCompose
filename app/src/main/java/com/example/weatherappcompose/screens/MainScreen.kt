package com.example.weatherappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(painter = painterResource(id = R.drawable.sky), contentDescription = "Sky background",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.6f),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(BlueLight),
            //elevation = CardDefaults.cardElevation(1.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "06 June 1944 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White,
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/143.png",
                        contentDescription = "Weather icon",
                        modifier = Modifier.size(35.dp)
                    )
                }
                Text(
                    text = "Ternopil",
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.White,
                )
                Text(
                    text = "24°C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White,
                )
                Text(
                    text = "Rain",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White,
                )
                Text(
                    text = "12°C / 24°C",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {

                    }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search icon",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {

                    }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "Search icon",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}