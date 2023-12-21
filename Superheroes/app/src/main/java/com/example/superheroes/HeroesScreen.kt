package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class HeroesScreen {
    @Composable
    fun SuperHeroListItem(modifier: Modifier = Modifier){
        Card(elevation = CardDefaults.cardElevation(2.dp),
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))) {
            Row (modifier = Modifier
                .height(72.dp)
                .padding(16.dp)){
                Column(modifier = Modifier){
                    Text(text = stringResource(id = R.string.hero1))
                    Text(text = stringResource(id = R.string.description1))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(painter = painterResource(id = R.drawable.android_superhero1), contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)))
            }
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