package com.akshatsahijpal.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 10.dp)) {
        TopBar(igId = "@im_akshat2001")
        Spacer(modifier = Modifier.height(10.dp))
        AboutSection()
        Spacer(modifier = Modifier.height(5.dp))
        ContentDescription(userName = "Akshat Sahijpal",
            descp = "Hello, I'm Akshat working on Android",
            followedBy = listOf("Nasa", "Google"))
        Spacer(modifier = Modifier.height(10.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        HighLightsSection(stories = listOf(HighLight(painterResource(id = R.drawable.ic_baseline_notifications_24),
            "Notification"),
            HighLight(painterResource(id = R.drawable.compose), "Jetpack"),
            HighLight(painterResource(id = R.drawable.pexels_pixabay_258510), "Pixel")),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        TabViewIn(onTabSelected = {}, imagesIcon = listOf(
            HighLight(photo = painterResource(id = R.drawable.ic_baseline_grid_on_24), "All Stories"),
            HighLight(photo = painterResource(id = R.drawable.ic_baseline_grid_on_24), "All Stories"),
            HighLight(photo = painterResource(id = R.drawable.ic_baseline_grid_on_24), "All Stories"),
            ))
    }
}

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
            RoundedPhoto(image = painterResource(id = R.drawable.compose),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f))
            Spacer(modifier = Modifier.width(15.dp))
            ProfileStats(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun TopBar(
    igId: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier.size(25.dp),
            tint = Color.Black)
        Text(text = igId,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold)
        Icon(painter = painterResource(id = R.drawable.ic_baseline_notifications_24),
            contentDescription = "Notification",
            modifier = Modifier.size(25.dp),
            tint = Color.Black)
        Icon(painter = painterResource(id = R.drawable.ic_baseline_drag_indicator_24),
            contentDescription = "Menu",
            modifier = Modifier.size(25.dp),
            tint = Color.Black)

    }
}

@Composable
fun RoundedPhoto(image: Painter, modifier: Modifier = Modifier) {
    Image(painter = image, contentDescription = "profile",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, shape = CircleShape, color = Color.Gray)
            .padding(5.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileStats(modifier: Modifier) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        ProfileStatsNum(num = 2, type = "Posts")
        ProfileStatsNum(num = 77, type = "Followers")
        ProfileStatsNum(num = 20, type = "Following")
    }
}

@Composable
fun ProfileStatsNum(num: Int, type: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = num.toString(), fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = type, fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ContentDescription(
    userName: String,
    descp: String,
    followedBy: List<String>,
) {
    Column(modifier = Modifier.padding(all = 5.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start) {
        Text(text = userName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = descp, fontSize = 17.sp, fontWeight = FontWeight.Light)
        Text(
            text = buildAnnotatedString {
                var style = SpanStyle(color = Color.Black, fontWeight = FontWeight.ExtraBold)
                append("Followed by ")
                followedBy.forEachIndexed { index, s ->
                    pushStyle(style = style)
                    append("$s, ")
                    if (index > 1) {
                        append("and 100 others")
                    }
                }
            },
            fontSize = 15.sp
        )
    }
}

/// Button Section
@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier, Arrangement.SpaceEvenly, Alignment.CenterVertically) {
        CustomButton(
            title = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = 105.dp)
                .height(30.dp)
        )
        CustomButton(
            title = "Message",
            icon = null,
            modifier = Modifier
                .defaultMinSize(minWidth = 95.dp)
                .height(30.dp)
        )
        CustomButton(
            title = "Email",
            icon = null,
            modifier = Modifier
                .defaultMinSize(minWidth = 95.dp)
                .height(30.dp)
        )
        CustomButton(
            title = null,
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = 55.dp)
                .height(30.dp)
        )
    }
}

@Composable
fun CustomButton(title: String? = null, icon: ImageVector? = null, modifier: Modifier = Modifier) {
    Row(modifier = modifier.border(width = 1.dp,
        shape = RoundedCornerShape(5.dp),
        color = Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        if (title != null) {
            Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}

@Composable
fun HighLightsSection(modifier: Modifier = Modifier, stories: List<HighLight>) {
    LazyRow(modifier = modifier) {
        items(stories.size) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(5.dp)) {
                RoundedPhoto(image = stories[it].photo, modifier = modifier.size(90.dp))
                Text(text = stories[it].title,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

data class HighLight(
    var photo: Painter,
    var title: String,
)

@Composable
fun TabViewIn(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedTab: Int) -> Unit,
    imagesIcon: List<HighLight>,
) {
    var selectedTabIndex: Int by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier,
        backgroundColor = Color.Transparent) {
        imagesIcon.forEachIndexed { index, highLight ->
            Tab(selected = selectedTabIndex == index, onClick = {
                selectedTabIndex = 0
                onTabSelected(0)
            }, selectedContentColor = Color.Black, unselectedContentColor = Color.Gray) {
                Icon(painter = highLight.photo,
                    contentDescription = highLight.title,
                    tint = if (selectedTabIndex == index) Color.Black else Color.Gray,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp))
            }
        }
    }
}