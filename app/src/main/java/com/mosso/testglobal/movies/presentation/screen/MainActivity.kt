package com.mosso.testglobal.movies.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mosso.testglobal.movies.presentation.viewmodel.MovieListViewModel
import com.mosso.testglobal.ui.theme.TestGlobalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestGlobalTheme {
                val state = viewModel.movieUIState.collectAsStateWithLifecycle().value
                val lazyListState = rememberLazyListState()
                MovieListScreen(
                    modifier = Modifier.padding(top = 32.dp, bottom = 8.dp),
                    uiState = state,
                    lazyListState = lazyListState,
                )
            }
        }
    }
}