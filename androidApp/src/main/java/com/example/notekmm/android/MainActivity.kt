package com.example.notekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notekmm.SampleViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SampleTextView()
                }
            }
        }
    }
}

@Composable
fun SampleTextView(
    viewModel: SampleViewModel = getViewModel()
) {
    Text(text = viewModel.getString())
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        SampleTextView()
    }
}
