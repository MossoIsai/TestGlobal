package com.mosso.testglobal.movies.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mosso.testglobal.R
import com.mosso.testglobal.core.presentation.ui.fontSansFamily

@Composable
fun Movie(
    modifier: Modifier = Modifier,
    text: String,
    titleMovie: String,
    descriptionMovie: String,
    scoreMovie: String,
    urlImage: String
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight()
            .padding(start = 10.dp, top = 16.dp, end = 10.dp, bottom = 8.dp)
    ) {
        Column {
            val basePhat = "https://image.tmdb.org/t/p/w500"
            AsyncImage(
                placeholder = painterResource(R.drawable.placeholder_movie),
                modifier = Modifier.size(width = 90.dp, height = 150.dp),
                contentDescription = text,
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(basePhat + urlImage)
                    .crossfade(true)
                    .build(),
            )
        }
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                text = titleMovie,
                fontFamily = fontSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 8.dp, top = 16.dp, bottom = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            )

            Text(
                text = descriptionMovie,
                fontFamily = fontSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = scoreMovie,
                fontSize = 15.sp,
                fontFamily = fontSansFamily,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, bottom = 16.dp, end = 8.dp)
                    .fillMaxWidth()
            )
        }
    }
}