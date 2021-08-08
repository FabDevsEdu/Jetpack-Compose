package com.akshatsahijpal.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }

    @Preview
    @Composable
    fun preview() {
        val scaffoldState = rememberScaffoldState()
        var textFState by remember {
            mutableStateOf("")
        }
        val scope = rememberCoroutineScope()
        Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                TextField(value = textFState, onValueChange = {
                    textFState = it
                }, label = {
                }, singleLine = true, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    scope.launch { scaffoldState.snackbarHostState.showSnackbar("$textFState") }
                }) {
                    Text(text = "Add")
                }
            }
        }
    }
}