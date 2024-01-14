package com.example.topics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    TopicGrid(
                        modifier = Modifier.fillMaxSize(),
                        topics = DataSource.topics
                    )
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
fun TopicGrid(
    modifier: Modifier = Modifier,
    topics: List<Topic>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(topics) { topic ->
            TopicCard(
                topic = topic,
            )
        }
    }
}

@Composable
fun TopicCard(
    modifier: Modifier = Modifier,
    topic: Topic,
) {
    Card(
        modifier = modifier
            .height(68.dp)
    ) {
        Row(modifier = modifier.weight(1f)) {
            Image(
                contentDescription = stringResource(id = topic.nameResourceId),
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f, true),
                painter = painterResource(id = topic.imageResourceId),
            )

            TopicDetails(topic = topic)
        }
    }
}

@Composable
fun TopicDetails(
    modifier: Modifier = Modifier,
    topic: Topic,
) {
    Column {
        Text(
            modifier = Modifier.padding(
                bottom = 8.dp,
                end = 16.dp,
                start = 16.dp,
                top = 16.dp,
            ),
            style = MaterialTheme.typography.bodyMedium,
            text = stringResource(id = topic.nameResourceId),
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                contentDescription = null,
                painter = painterResource(id = R.drawable.ic_grain),
            )

            Text(
                modifier = modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.labelMedium,
                text = "${topic.courseCount}",
            )
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