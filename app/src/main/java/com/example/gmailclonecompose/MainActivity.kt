package com.example.gmailclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailclonecompose.components.HomeAppBar
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
    Scaffold(topBar = {HomeAppBar()}) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneComposeTheme {
        GmailApp()
    }
}