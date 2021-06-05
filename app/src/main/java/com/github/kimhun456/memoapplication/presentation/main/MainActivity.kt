package com.github.kimhun456.memoapplication.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.kimhun456.memoapplication.domain.entity.Memo
import com.github.kimhun456.memoapplication.presentation.theme.MaterialMemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    MemoList(viewModel)
                    AddButton(viewModel)
                }
            }
        }
    }

    @Composable
    fun MainActivityTheme(content: @Composable () -> Unit) {
        MaterialMemoTheme {
            Surface(color = Color.LightGray) {
                content()
            }
        }
    }

    @Composable
    fun MemoList(viewModel: MainViewModel) {
        val memoList by viewModel.memoList.observeAsState(listOf())
        LazyColumn(
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = memoList) { memo ->
                MemoCard(memo)
            }
        }
    }

    @Composable
    fun AddButton(viewModel: MainViewModel) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.addMemo() }) {
            Text(text = "Create Memo")
        }
    }

    @Preview
    @Composable
    fun PreviewMemoCard() {
        MemoCard(
            Memo(
                id = 0L,
                title = "title",
                message = "Hello",
                createdTime = 0L,
                lastModifiedTime = 0L
            )
        )
    }

    @Composable
    fun MemoCard(memo: Memo) {
        Column {
            Text(text = memo.title)
            Divider(modifier = Modifier.height(1.dp))
            Text(text = memo.message)
        }
    }
}