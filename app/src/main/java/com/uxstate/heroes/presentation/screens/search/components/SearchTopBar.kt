package com.uxstate.heroes.presentation.screens.search.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.topAppBarBackgroundColor
import com.uxstate.heroes.presentation.ui.theme.topAppBarContentColor
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Surface(
            modifier = modifier
                    .padding(spacing.spaceSmall)
                    .semantics { contentDescription = "SearchWidget" },
            elevation = AppBarDefaults.TopAppBarElevation,
            color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {


        TextField(
                modifier = Modifier.fillMaxWidth().semantics { contentDescription = "TextField" },
                value = text,
                onValueChange = { onTextChange(it) },
                placeholder = {
                    Text(
                            text = "Search Here ...",
                            color = Color.White,
                            modifier = Modifier.alpha(ContentAlpha.medium)
                    )
                },

                //TextStyle always take precedence over TextField colors
                textStyle = TextStyle(
                        color = MaterialTheme.colors.topAppBarContentColor
                ),

                //access other colors values for TextField
                colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        backgroundColor = Color.Transparent,
                        cursorColor = MaterialTheme.colors.topAppBarContentColor
                ),

                singleLine = true,

                //leading icon with ContentAlpha.Medium to dull it
                leadingIcon = {
                    Icon(
                            modifier = Modifier.alpha(alpha = ContentAlpha.medium),
                            imageVector = Icons.Default.Search,
                            tint = MaterialTheme.colors.topAppBarContentColor,
                            contentDescription = stringResource(
                                    R.string.search_lable
                            )
                    )
                },


                trailingIcon = {
                    IconButton(onClick = {

                        //delete present text
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        }

                        //otherwise trigger onClose() to end search
                        else {
                            onClose()
                        }


                    }, modifier = Modifier.semantics { contentDescription = "CloseIcon" }) {

                        //trailing icon has full visibility
                        Icon(
                                imageVector = Icons.Default.Close,
                                tint = MaterialTheme.colors.topAppBarContentColor,
                                contentDescription = stringResource(R.string.close_label)
                        )
                    }
                },

                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearch(text) })
        )

    }

}


@Preview(name = "Light", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SearchWidgetPreviewLight() {

    SearchWidget(text = "Me Boss", onTextChange = {}, onSearch = {}, onClose = { })

}


@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchWidgetPreviewDark() {

    SearchWidget(text = "The Boss", onTextChange = {}, onSearch = {}, onClose = { })

}