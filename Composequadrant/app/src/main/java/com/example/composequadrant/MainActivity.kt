package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UI()
                }
            }
        }
    }
}

@Composable
fun UI(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier
            .weight(1f)
            .fillMaxSize()) {
            CardQuadrant(
                first = "Text composable",
                second = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                color = 0xFFEADDFF
            )
            CardQuadrant(
                first = "Image composable",
                second = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                color = 0xFFD0BCFF
            )
        }
        Row(modifier = modifier
            .weight(1f)
            .fillMaxSize()) {
            CardQuadrant(
                first = "Row composable",
                second = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                color = 0xFFB69DF8
            )
            CardQuadrant(
                first = "Column composable",
                second = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                color = 0xFFF6EDFF
            )
        }
    }
}

@Composable
fun CardQuadrant(modifier: Modifier = Modifier, first: String, second: String, color: Long) {
    Card(
        modifier = modifier
            .fillMaxSize()
            ,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color(color))
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()) {
            Text(text = first, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom=16.dp))
            Text(text = second, textAlign = TextAlign.Justify, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}


@Composable
@Preview
fun UIPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        UI()
    }
}

