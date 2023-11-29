package com.example.lemonade

import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    var imageResource = when (index) {
        0 -> painterResource(id = R.drawable.lemon_tree)
        1 -> painterResource(id = R.drawable.lemon_squeeze)
        2 -> painterResource(id = R.drawable.lemon_drink)
        else -> painterResource(id = R.drawable.lemon_restart)
    }
    var stringResource = when (index) {
        0 -> stringResource(id = R.string.lemon_tree)
        1 -> stringResource(id = R.string.lemon_squeeze)
        2 -> stringResource(id = R.string.lemon_drink)
        else -> stringResource(id = R.string.lemon_restart)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Cyan)) {
            Image(
                painter = imageResource,
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        if (index == 3) {
                            index = 0
                        } else {
                            index++
                        }
                    }
            )
        }
        Text(text = stringResource, fontSize = 16.sp, modifier = Modifier.padding(top = 20.dp))
    }
}

@Composable
@Preview
fun LemonadePreview() {
    Surface {
        Lemonade(modifier = Modifier.fillMaxSize())
    }
}