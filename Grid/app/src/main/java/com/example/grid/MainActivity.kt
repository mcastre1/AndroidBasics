package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.data.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme
import com.example.grid.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
    listOf(
        TopicGrid(
            topicList = DataSource().topics
        )
    )
}

@Composable()
fun TopicGrid(modifier: Modifier = Modifier, topicList: List<Topic>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(topicList) { topic ->
            TopicItem(topic = topic)
        }
    }
}

@Composable
fun TopicItem(modifier: Modifier = Modifier, topic: Topic) {
    Card(modifier = modifier) {
        Row() {
            Image(
                painter = painterResource(id = topic.imageResourceId), contentDescription = null,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column() {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    style = Typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_action_grid),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.associatedTotal.toString(),
                        style = Typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TopicItemPreview() {
    GridTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val temp = Topic(R.string.architecture, 58, R.drawable.architecture)
            TopicItem(topic = temp)
        }
    }
}


@Preview
@Composable
fun TopicGridPreview() {
    GridTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TopicApp()
        }
    }
}

