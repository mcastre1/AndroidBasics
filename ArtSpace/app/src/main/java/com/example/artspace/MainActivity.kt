package com.example.artspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpace()
                }

            }
        }
    }

    @Composable
    fun ArtSpace(modifier: Modifier = Modifier) {
        var index by remember { mutableStateOf(0) }

        var imageResource: Painter? = null
        imageResource = when(index){
            0 -> painterResource(id = R.drawable.mona_lisa)
            1-> painterResource(id = R.drawable.waves)
            else -> {
                painterResource(id = R.drawable.van_gogh)
            }
        }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageSection(Modifier.padding(bottom = 50.dp, top = 50.dp), imageResource = imageResource)
            ImageDescription()
            ButtonSection(onPrevious = {if(index > 0){
                index--
            } }, onNext = {if(index < 2){
                index++
            } })
        }
    }

    @Composable
    fun ImageSection(modifier: Modifier = Modifier, imageResource:Painter) {
        Surface (modifier = modifier.padding(20.dp), shadowElevation = 20.dp,){
            Image(painter = imageResource, contentDescription = null, Modifier.padding(40.dp))
        }
    }

    @Composable
    fun ImageDescription(modifier: Modifier = Modifier) {
        Surface(color = Color.LightGray, modifier = modifier.padding(bottom = 30.dp)) {
            Column (modifier.padding(15.dp)){
                Text(text = "Sailing Under the Bridge")
                Text(text = "Image Description")
            }
        }
    }

    @Composable
    fun ButtonSection(modifier: Modifier = Modifier, onNext:()->Unit, onPrevious:()->Unit) {
        Row (modifier.padding(10.dp)){
            Button(onClick = onPrevious, modifier= Modifier
                .padding(horizontal = 10.dp)
                .width(150.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = onNext, modifier= Modifier
                .padding(horizontal = 10.dp)
                .width(150.dp)) {
                Text(text = "Next")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ArtSpacePreview() {
        ArtSpaceTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                ArtSpace()
            }
        }
    }
}
