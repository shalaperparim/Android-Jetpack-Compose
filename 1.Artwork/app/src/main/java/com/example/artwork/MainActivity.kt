package com.example.artwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artwork.ui.theme.ArtworkTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtworkTheme {
                ArtSpaceApp()
            }
        }
    }
}

data class Artwork(
    val title: String,
    val artist: String,
    val year: Int,
    val imageRes: Int
)

@Composable
fun ArtSpaceApp() {
    // Dummy list of artworks for demonstration
    val artworks = listOf(
        Artwork("Artwork 1", "Perparim SHALA", 2020, R.drawable.bee),
        Artwork("Artwork 2", "Ylfete Selmani Shala", 2021, R.drawable.bee1),
        Artwork("Artwork 3", "Vesa", 2022, R.drawable.bee2),
        Artwork("Artwork 4", "Vesa 2", 2022, R.drawable.bee3)
    )

    // State to keep track of the current index
    val currentIndex = remember { mutableStateOf(0) }

    // UI for the Art Space app
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Artwork wall section
        ArtworkImageSection(artworks[currentIndex.value])

        // Artwork descriptor section
        ArtworkDescriptorSection(artworks[currentIndex.value])

        // Spacer to push the buttons to the bottom
        //Spacer(modifier = Modifier.weight(1f))

        // Display controller section with currentIndex and artworks passed as parameters
        DisplayControllerSection(currentIndex, artworks)
    }
}


@Composable
fun ArtworkImageSection(artwork: Artwork) {
    Image(
        painter = painterResource(id = artwork.imageRes),
        contentDescription = null, // Set to null if the image is decorative
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ArtworkDescriptorSection(artwork: Artwork) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = artwork.title, style = MaterialTheme.typography.headlineSmall)
        Text(text = "by ${artwork.artist}, ${artwork.year}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun DisplayControllerSection(currentIndex: MutableState<Int>, artworks: List<Artwork>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(100.dp)
    ) {
        Button(
            onClick = {
                if (currentIndex.value > 0) {
                    currentIndex.value--
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Previous")
        }

        Button(
            onClick = {
                if (currentIndex.value < artworks.size - 1) {
                    currentIndex.value++
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtSpaceApp() {
    ArtSpaceApp()
}