package com.faracoder.lazyrowlazycolumnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faracoder.lazyrowlazycolumnapp.ui.theme.LazyRowLazyColumnAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowLazyColumnAppTheme {
                val languages = listOf(
                    "Java",
                    "Kotlin",
                    "Python",
                    "Dart",
                    "PHP",
                    "XML",
                    "HTML",
                    "Javascript",
                    "R",
                    "Golang",
                    "C++",
                    "Swift",
                    "Verilog",
                    "Solitude",
                    "Rust"
                )
                MyApp(modifier = Modifier,
                    languages
                )
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    languages: List<String>
) {
    Column(modifier.fillMaxSize()) {
        LazyRow() {
            items(items = languages) {item ->
                RowItem(modifier = modifier, name = item)
            }
        }
        LazyColumn() {
            items(items = languages) {item ->
                ColumnItem(modifier = modifier, name = item)
            }
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, name: String) {
   Card(
       modifier
           .padding(10.dp)
           .fillMaxWidth()
           .height(100.dp)
           .aspectRatio(1.5f),
       colors = CardDefaults.cardColors(containerColor = Color.White),
       elevation = CardDefaults.cardElevation(20.dp)
   ) {
       Box(
           modifier
               .padding(10.dp)
               .fillMaxSize(),
           contentAlignment = Alignment.Center
       ) {
           Text(
               text = name,
               fontSize = 22.sp,
               fontWeight = FontWeight.Bold
           )
       }
   }
}

@Composable
fun ColumnItem(modifier: Modifier, name: String) {
    Card(
        modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(20.dp)
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}