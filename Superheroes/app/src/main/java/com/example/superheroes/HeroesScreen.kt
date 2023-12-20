package com.example.superheroes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class HeroesScreen {
    @Composable
    fun SuperHeroListItem(modifier: Modifier = Modifier){
        Card(elevation = CardDefaults.cardElevation(2.dp),
            modifier = modifier.fillMaxWidth()
                .height(72.dp)) {

        }
    }

    @Preview
    @Composable
    fun SuperHeroListItemPreview(){
        Surface(){
            SuperHeroListItem()
        }

    }
}