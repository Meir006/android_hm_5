package com.example.build_a_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Block(
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId: Int,
    val availableCourses: Int
)
