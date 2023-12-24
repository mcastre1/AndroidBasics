package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val HS = HeroesScreen()
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                HS.ListSuperHeroes()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroesApp(modifier: Modifier = Modifier){
    Scaffold(topBar = {
        TopBar()
    }) {
        val HS = HeroesScreen()
        HS.ListSuperHeroes()
    }


}



@Preview
@Composable
fun SuperheroesAppPreview(){

    SuperheroesApp()
}

@Composable
fun TopBar(modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        Text(text = "Superheroes", style = MaterialTheme.typography.displayLarge, )
    }
}
