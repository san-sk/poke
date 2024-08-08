package com.san.demo.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun PokeSearch(
    modifier: Modifier = Modifier,
    threshold: Int = 3,
    onClear: () -> Unit,
    onSearch: (query: String) -> Unit,
) {
    var searchString by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = MaterialTheme.shapes.extraLarge,
        value = searchString,
        placeholder = { Text(text = "Search name, id, type") },
        label = { Text(text = "Search") },
        singleLine = true,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        },
        trailingIcon = {
            if (searchString.isNotEmpty()) {
                IconButton(onClick = {
                    searchString = ""
                    onClear()
                }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                }

            }
        },
        onValueChange = {
            searchString = it
            if (searchString.isEmpty()) {
              //  onSearch(searchString)
                onClear()
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onSearch(searchString)
        })
    )
}