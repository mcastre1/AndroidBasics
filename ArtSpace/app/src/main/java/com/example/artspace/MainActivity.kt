package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageSection()
            ImageDescription()
            ButtonSection()
        }
    }

    @Composable
    fun ImageSection(modifier: Modifier = Modifier) {
        Surface {
            val imageResource = painterResource(id = R.drawable.mona_lisa)
            Image(painter = imageResource, contentDescription = null)
        }
    }

    @Composable
    fun ImageDescription(modifier: Modifier = Modifier) {
        Surface() {
            Column {
                Text(text = "Image Title")
                Text(text = "Image Description")
            }
        }
    }

    @Composable
    fun ButtonSection(modifier: Modifier = Modifier) {
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Previous")
            }
            Button(onClick = { /*TODO*/ }) {
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
