package com.example.mvicounterapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvicounterapplication.intent.CounterIntent
import com.example.mvicounterapplication.ui.theme.MVICounterApplicationTheme
import com.example.mvicounterapplication.ui.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVICounterApplicationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val state = viewModel.state.collectAsState().value

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Count: ${state.count}")

        Button(
            onClick = { viewModel.handleIntent(CounterIntent.Increment) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Increment")
        }

        Button(
            onClick = { viewModel.handleIntent(CounterIntent.Decrement) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Decrement")
        }
    }
}