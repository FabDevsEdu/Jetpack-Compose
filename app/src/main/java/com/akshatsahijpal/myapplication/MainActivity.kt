package com.akshatsahijpal.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akshatsahijpal.myapplication.ui.models.MainViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getContentStateful()
        }
    }
    @Composable
    fun getContentStateful() {
        var ix by rememberSaveable {
            mutableStateOf("")
        }
        getContentStateless(ix) {
            ix = it
        }
    }
    @Composable
    fun getContentStateless(
        cv: String,
        changeCv: (String) -> Unit)
    {
        Column(modifier = Modifier.fillMaxSize(0.5f)) {
            Text(text = "Current Version = $cv")
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(value = cv, onValueChange = changeCv, label = { Text(text = "CV")})
        }
    }
}