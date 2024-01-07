package com.example.inspiration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inspiration.data.Datasource
import com.example.inspiration.model.Inspiration
import com.example.inspiration.ui.theme.InspirationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InspirationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InspirationApp()
                }
            }
        }
    }
}

@Composable
fun InspirationApp() {
    InspirationList(
        inspirationList = Datasource().loadAffirmations(),
    )
}

@Composable
fun InspirationList(inspirationList: List<Inspiration>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(inspirationList.size) { index ->
            InspirationCard(
                inspiration = inspirationList[index],
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun InspirationCard(inspiration: Inspiration, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(inspiration.imageResourceId),
                contentDescription = stringResource(inspiration.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = LocalContext.current.getString(inspiration.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    InspirationCard(Inspiration(R.string.inspiration1, R.drawable.image1))
}
