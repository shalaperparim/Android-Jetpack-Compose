package com.example.inspiration.data

import com.example.inspiration.R
import com.example.inspiration.model.Inspiration

class Datasource() {
    fun loadAffirmations(): List<Inspiration> {
        return listOf<Inspiration>(
            Inspiration(R.string.inspiration1, R.drawable.image1),
            Inspiration(R.string.inspiration2, R.drawable.image2),
            Inspiration(R.string.inspiration3, R.drawable.image3),
            Inspiration(R.string.inspiration4, R.drawable.image4),
            Inspiration(R.string.inspiration5, R.drawable.image5),
            Inspiration(R.string.inspiration6, R.drawable.image6),
            Inspiration(R.string.inspiration7, R.drawable.image7),
            Inspiration(R.string.inspiration8, R.drawable.image8),
            Inspiration(R.string.inspiration9, R.drawable.image9),
            Inspiration(R.string.inspiration10, R.drawable.image10))
    }
}

// Note: The loadAffirmations() method gathers all of the data provided
