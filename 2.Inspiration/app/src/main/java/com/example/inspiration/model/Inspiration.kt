package com.example.inspiration.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Inspiration(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
