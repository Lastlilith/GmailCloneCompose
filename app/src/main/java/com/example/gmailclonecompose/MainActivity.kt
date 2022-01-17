package com.example.gmailclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailclonecompose.components.GmailDrawerMenu
import com.example.gmailclonecompose.components.HomeAppBar
import com.example.gmailclonecompose.components.HomeBottomMenu
import com.example.gmailclonecompose.components.MailList
import com.example.gmailclonecompose.ui.theme.GmailCloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        }) {
        MailList(paddingValues = (it))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneComposeTheme {
        GmailApp()
    }
}