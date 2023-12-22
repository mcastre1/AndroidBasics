package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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

@Composable
fun SuperheroesApp(modifier: Modifier = Modifier){
    val HS = HeroesScreen()
    HS.ListSuperHeroes()
}



@Preview
@Composable
fun SuperheroesAppPreview(){
    SuperheroesApp()
}
