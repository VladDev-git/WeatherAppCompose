package com.example.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherappcompose.screens.MainCard
import com.example.weatherappcompose.screens.TabLayout

//const val API_KEY = "59164c9607654385ad1150429240407"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Image(painter = painterResource(id = R.drawable.sky), contentDescription = "Sky background",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.6f),
                contentScale = ContentScale.Crop
            )
            Column {
                MainCard()
                TabLayout()
            }

        }
    }
}