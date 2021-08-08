package com.akshatsahijpal.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           LazyColumn{
               itemsIndexed(listOf("a", "b", "c")){ index, item -> }
               items(400){
                   Text(text = "for $it")
               }
           }
        }
    }
}
@Preview
@Composable
fun prev() {
    var scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(state = scrollState)){
        for (i in 1..20){
            Text(text = "$i")
        }
    }
}