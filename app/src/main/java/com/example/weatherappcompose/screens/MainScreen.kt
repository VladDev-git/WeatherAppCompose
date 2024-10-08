package com.example.weatherappcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
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

//@Preview(showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        androidx.compose.material.TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                androidx.compose.material.TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, pos)
                )
            },
            backgroundColor = BlueLight,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = text,
                            color = if (pagerState.currentPage == index) Color.White else Color.Gray
                        )
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(15) {
                    ListItem()
                }
            }
        }
    }
}