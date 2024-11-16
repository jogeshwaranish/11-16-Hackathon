@file:Suppress("DEPRECATION")

package com.example.kotlin_124_honors

import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_124_honors.ui.theme.Kotlin124honorsTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private val logTag = MainActivity::class.java.simpleName

    private val stringList = mutableListOf("Go do your work", "WORKWORKWORKWORK", "I know your not doing your work", "Your mother would not be proud", "Your literally bad", "Come on you can do better", "Yikes you suck", "How lame", "Really? No work?", "Even I could do better than you", "Skill issue", "Sucker", "Why are you here? Go back to work!", "You can go on your phone later", "lol ur bad")

    private fun readFireStore(): String {
        return stringList[Random.nextInt(0, stringList.size)]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultText = findViewById<TextView>(R.id.resultText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val message = readFireStore()
            resultText.text = message
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text("Account-a-Buddy", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun StartScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Placeholder for an illustration
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your custom drawable
            contentDescription = "App Icon",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Are you procrastinating?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Click the button above",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
@Composable
fun StartCalendar() {

}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    Kotlin124honorsTheme {
        Scaffold(
            topBar = { AppTopBar() }
        ) {
            StartScreenContent(modifier = Modifier.padding(it))
            StartCalendar()
        }
    }
}
