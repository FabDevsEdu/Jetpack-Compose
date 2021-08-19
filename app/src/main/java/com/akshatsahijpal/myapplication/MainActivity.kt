package com.akshatsahijpal.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity(enabled: Boolean) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    @Composable
    fun ErrorBar() {
        var scaffoldState = rememberScaffoldState()
        Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize(0.5f)) {
            var counter:Int by remember{
                mutableStateOf(0)
            }
            LaunchedEffect(key1 = scaffoldState.snackbarHostState){
                scaffoldState.snackbarHostState.showSnackbar("Counting for $counter")
            }
            Button(onClick = {
                counter++
            }) {
               Text(text = "Current Value :${counter}")
            }
        }
    }
}