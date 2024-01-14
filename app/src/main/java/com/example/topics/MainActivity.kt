package com.example.topics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.topics.model.DataSource
import com.example.topics.ui.theme.TopicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

data class Topic(
    @StringRes val nameResourceId: Int,
    val courseCount: Int,
    @DrawableRes val imageResourceId: Int,
)

@Composable
fun TopicCard(
    modifier: Modifier = Modifier,
    topic: Topic,
) {
    Card {
        Row {

        }
    }
}

@Preview
@Composable
fun TopicCardPreview() {
    TopicCard(
        topic = DataSource.topics[0]
    )
}