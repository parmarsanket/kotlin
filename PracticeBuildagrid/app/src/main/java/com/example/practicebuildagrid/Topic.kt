package com.example.practicebuildagrid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val title: Int,
                 val label: Int,
                @DrawableRes val img :Int
)
