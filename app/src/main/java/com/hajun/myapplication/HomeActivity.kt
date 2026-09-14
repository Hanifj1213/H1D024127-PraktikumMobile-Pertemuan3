package com.hajun.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hajun.myapplication.ui.screen.DaftarProdukScreen
import com.hajun.myapplication.ui.theme.MyApplicationTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                DaftarProdukScreen()
            }
        }
    }
}
