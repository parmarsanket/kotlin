package com.example.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title:String,val route:String) {
sealed class DrawerScreen(val dtitle:String,
                          val dRoute:String,
                          @DrawableRes val icon:Int)
    :Screen(dtitle,dRoute)
{
     object Account:DrawerScreen(
         dtitle = "Account",
         dRoute = "account",
         R.drawable.baseline_account_box_24
     )
    object Subscription:DrawerScreen(
        dtitle = "Subscription",
        dRoute = "subscribe",
        R.drawable.baseline_library_music_24
    )
    object AddAccount : DrawerScreen(
        dtitle = "Add Account",
        dRoute = "add_account",
        icon = R.drawable.baseline_person_add_alt_1_24
    )
    }
}
val screenInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subscription
)