package com.example.goodreadsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.goodreadsapp.R
import com.example.goodreadsapp.ui.navigation.NavRoutes

@Composable
fun MyBooksScreen(navController: NavController, viewModel: MyBooksViewModel = MyBooksViewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFE4E2D5)),
            contentAlignment = Alignment.Center
        ) {
//            Text("home_logo", style = MaterialTheme.typography.titleLarge)
            Image(
                painter = painterResource(R.drawable.home_logo),
                contentDescription = null,
                modifier = Modifier.height(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {

            ListButton(
                text = "Reading",
                gradient = Brush.horizontalGradient(listOf(Color.Red, Color(0xFFFF6347))),
                onClick = { navController.navigate("mybooks/list/Reading") }

            )

            ListButton(
                text = "Want to read",
                gradient = Brush.horizontalGradient(listOf(Color(0xFFFFA500), Color(0xFFFFD700))),
                onClick = { navController.navigate("mybooks/list/WantToRead") }
            )

            ListButton(
                text = "Read",
                gradient = Brush.horizontalGradient(listOf(Color(0xFF00FF00), Color(0xFF32CD32))),
                onClick = { navController.navigate("mybooks/list/Read") }
            )
        }
    }
}

@Composable
fun ListButton(text: String, gradient: Brush, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
            .background(brush = gradient, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.White, style = MaterialTheme.typography.titleMedium)
    }
}
