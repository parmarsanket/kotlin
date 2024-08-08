package com.example.wishlistapp2

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppbarView
        (title: String ,
         onBackNavClicked: () -> Unit
       )
{
            val content= LocalContext.current
            val navigationicon  :@Composable () -> Unit =
                if(!title.contains("Wishlist"))
                {
                    {
                        IconButton(onClick = { onBackNavClicked() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack ,
                                contentDescription = "" , tint = Color.White
                            )
                        }
                    }
                }else {
                    {}
                }

            TopAppBar(
                title ={ Text(text = title,color = Color.White, )

            },
                modifier = Modifier.heightIn(max = 50.dp)
                    
                      ,
                navigationIcon = navigationicon,
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red )
            )




       }
