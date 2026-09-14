package com.hajun.myapplication.ui.screen

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hajun.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hajun.myapplication.R
import com.hajun.myapplication.ui.theme.Primary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HubungiKamiScreen(navController: NavController) {
    var emailText by remember { mutableStateOf("") }
    var messageText by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Hubungi Kami",
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Kembali"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = androidx.compose.ui.graphics.Color.White,
                    navigationIconContentColor = androidx.compose.ui.graphics.Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mail_icon),
                contentDescription = "Mail Icon",
                tint = Primary,
                modifier = Modifier
                    .height(64.dp)
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text("Email") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mail_icon),
                        contentDescription = "Email Icon"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                label = { Text("Pesan") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 5
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Pesan Terkirim")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.send_icon),
                    contentDescription = "Send Icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "Kirim Pesan")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HubungiKamiScreenPreview() {
    MyApplicationTheme {
        HubungiKamiScreen(navController = rememberNavController())
    }
}
