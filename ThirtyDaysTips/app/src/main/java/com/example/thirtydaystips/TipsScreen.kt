package com.example.thirtydaystips

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaystips.model.Tip
import com.example.thirtydaystips.model.TipDataSource

class TipsScreen {

    @Composable
    fun TipList(
        modifier: Modifier = Modifier,
        tips: List<Tip>,
        contentPadding: PaddingValues = PaddingValues(0.dp)
    ) {
        LazyColumn(contentPadding = contentPadding){
            itemsIndexed(tips){
                index, tip ->
                TipListItem(tip = tip, modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp))
            }
        }

    }

    @Composable
    fun TipListItem(tip: Tip, modifier: Modifier = Modifier) {
        var expanded by remember { mutableStateOf(false) }

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = modifier
                .fillMaxWidth()
                .clickable {expanded = !expanded}
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = stringResource(id = tip.dayRes))
                Text(text = stringResource(id = tip.titleRes))
                Image(
                    painter = painterResource(id = tip.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp)
                )
                if(expanded){
                    Text(text = stringResource(id = tip.descRes))
                }
            }
        }
    }

    @Composable
    @Preview
    fun TipListItemPreview() {
        TipListItem(tip = TipDataSource.tips[10])
    }

    @Composable
    @Preview
    fun TipListPreview() {
        TipList(tips = TipDataSource.tips)
    }
}