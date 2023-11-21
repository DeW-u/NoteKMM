package com.example.notekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notekmm.data.domain.NoteDomain
import com.example.notekmm.feature_notes_list.presentation.NotesListViewModel
import com.example.notekmm.utils.Colors
import org.koin.androidx.compose.getViewModel
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = getViewModel<NotesListViewModel>()

                    val notesState = viewModel.notesFlow.collectAsState(initial = emptyList())

                    Column {
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            modifier = Modifier
                                .wrapContentSize()
                                .align(Alignment.CenterHorizontally),
                            onClick = {
                                viewModel.insertNote(
                                    NoteDomain(
                                        null,
                                        "NOTE:${Random.nextInt(0, 9999)}",
                                        "test",
                                        Colors.generateRandomColor(),
                                        System.currentTimeMillis()
                                    )
                                )
                            }
                        ) {
                            Text(text = "INSERT NOTE")
                        }

                        LazyColumn {
                            notesState.value.forEach {
                                item {
                                    SampleTextView(it.title + " " + it.getDateTimeString())
                                }
                            }
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun SampleTextView(
    text: String
) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        SampleTextView("sample")
    }
}
