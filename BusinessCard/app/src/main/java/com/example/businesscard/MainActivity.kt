package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0x78f09e)
                ) {
                    UI()
                }
            }
        }
    }
}

@Composable
fun UI(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0x78f09e))) {
        Logo(modifier = Modifier.weight(1f))
        Contact(modifier = Modifier.weight(4f))
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    var image = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 250.dp, bottom = 250.dp)
            .background(color = Color(0x78f09e))
    ) {
        Box() {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color.Black)
                    .clip(RoundedCornerShape(16.dp))
                    .height(100.dp)
                    .width(100.dp)
            )
        }
        Text(text = "Miguel Castrejon", fontSize = 15.sp)
        Text(text = "Android Developer Extraordinaire")
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0x78f09e))
    ) {
        Row() {
            Icon(Icons.Rounded.Menu, contentDescription = null)
            Text(text = "+1 (801) 859 8462")
        }
        Row() {
            Text(text = "@Mcastre1")
        }
        Row() {
            Text(text = "miguelcastrejongal@gmail.com")
        }
    }
}

@Composable
@Preview
fun UIPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UI()
        }
    }
}