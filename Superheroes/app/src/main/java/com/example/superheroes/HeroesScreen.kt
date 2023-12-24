package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository

class HeroesScreen {
    @Composable
    fun SuperHeroListItem(modifier: Modifier = Modifier, hero: Hero){
        Card(elevation = CardDefaults.cardElevation(2.dp),
            modifier = modifier) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight=72.dp)){
                Column(modifier = Modifier.weight(1f)){
                    Text(text = stringResource(id = hero.nameRes), style = MaterialTheme.typography.displaySmall, modifier = Modifier.fillMaxWidth())
                    Text(text = stringResource(id = hero.descriptionRes), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.fillMaxWidth())
                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(painter = painterResource(id = hero.imageRes), contentDescription = null,
                    modifier = Modifier.size(72.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit)
            }
        }
    }

    @Composable
    fun ListSuperHeroes(modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues(0.dp)){
        LazyColumn(contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)){
            items(HeroesRepository.heroes){
                SuperHeroListItem(hero = it, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp))
            }
        }
    }

    @Composable
    @Preview
    fun ListSuperHeroesPreview(modifier: Modifier = Modifier){
        ListSuperHeroes()
    }

    @Preview
    @Composable
    fun SuperHeroListItemPreview(){
        SuperHeroListItem(hero = HeroesRepository.heroes.get(1))
    }
}