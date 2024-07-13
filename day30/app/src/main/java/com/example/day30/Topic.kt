package com.example.day30

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title:Int,

    @DrawableRes val img :Int

)
