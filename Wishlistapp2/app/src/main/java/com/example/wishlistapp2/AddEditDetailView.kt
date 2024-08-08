package com.example.wishlistapp2

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditDetailView(
    id :Long ,
    viewModel : WishlistViewModel,
    navController : NavController,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    val snackmessage = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()

   if(id != 0L)
   {
     val wish = viewModel.getwishbyid(id).collectAsState(initial = Wish(0L,"",""))
       viewModel.wishTileSate = wish.value.title
       viewModel.wishDescriptionState = wish.value.description
   }
   else
   {
       viewModel.wishTileSate = ""
       viewModel.wishDescriptionState = ""
   }

    Scaffold(modifier = modifier ,

        topBar =
        {
            AppbarView(
                title = if (id != 0L) stringResource(id = R.string.updated_Wish) else
                    stringResource(id = R.string.add_Wish),
                onBackNavClicked = {
                    navController.navigateUp()
                }
            )


        },
       scaffoldState = scaffoldState
    )
    {
        Column(modifier = modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(20.dp))
           WishTextField(value = viewModel.wishTileSate ,
               onTextChange = {viewModel.onwishTileStateChanged(it)} , label = "title")
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(value = viewModel.wishDescriptionState ,
                onTextChange = {viewModel.onWishDescriptionStateChanged(it)} ,
                label ="Drscription" )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if(viewModel.wishTileSate.isNotEmpty()
                    && viewModel.wishDescriptionState.isNotEmpty())
                {
                    if(id!=0L)
                    {
                        //update wish

                        viewModel.updateWish(
                            Wish(
                            id = id,
                            title = viewModel.wishTileSate.trim(),
                            description = viewModel.wishDescriptionState.trim()
                            )
                        )
                        snackmessage.value = "wish has been updated"
                    }
                    else
                    {
                        //Tode add
                        viewModel.addWish(
                            Wish(
                                title = viewModel.wishTileSate.trim(),
                                description = viewModel.wishDescriptionState.trim(),
                            )
                        )
                        snackmessage.value = "wish has been created"
                    }

                }
                else{
                    //enter field for wish to be created
                    snackmessage.value = "enter field for wish to be created"
                }
                focusManager.clearFocus()
                scope.launch {

//                    scaffoldState.snackbarHostState.showSnackbar(snackmessage.value, duration =
//                    SnackbarDuration.Short)

                    Toast.makeText(context, snackmessage.value ,Toast
                        .LENGTH_SHORT).show()


                    navController.navigate(Screen.Home.route)
                }
            }) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.updated_Wish) else
                        stringResource(id = R.string.add_Wish) , style = TextStyle(fontSize = 18.sp)
                )
            }


        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishTextField(
    value: String,
    onTextChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
)
{
    OutlinedTextField(value = value ,
        onValueChange = onTextChange,
        label = { Text(text = label,color = Color.Black)},
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors()

    )
    
}





