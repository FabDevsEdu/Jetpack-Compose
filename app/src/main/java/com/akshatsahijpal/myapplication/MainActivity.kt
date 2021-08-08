package com.akshatsahijpal.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFState by remember {
                mutableStateOf("")
            }
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
                    TextField(value = textFState, onValueChange = {
                    }, label = {

                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(5.dp)
        .padding(top = 20.dp)) {
        ImageCardCompose(painter = painterResource(id = R.drawable.pexels_pixabay_258510),
            contentDes = "Railway Tracks", title = "Journey", modifier = Modifier)
    }
}

@Composable
fun ImageCardCompose(
    painter: Painter,
    contentDes: String,
    title: String,
    modifier: Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp), elevation = 10.dp
    ) {
        Box(modifier = Modifier.height(150.dp)) {
            Image(
                painter = painter, contentDescription = contentDes, contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 300f
                )))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = title, style = TextStyle(fontSize = 15.sp, color = Color.Cyan))
            }
        }

    }
}

@Composable
fun StateBox(modifier: Modifier) {
    var colorState = remember {
        mutableStateOf(Color.Red)
    }
    Box(modifier = modifier
        .background(colorState.value)
        .clickable {
            colorState.value = Color.Blue
        })
}