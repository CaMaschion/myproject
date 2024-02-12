package com.camila.myproject.loginscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camila.myproject.ui.theme.Pink80
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.PasswordVisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClicked: (String) -> Unit) {
    var username by remember {
        mutableStateOf(TextFieldValue())
    }
    var enteredPassword by remember {
        mutableStateOf(TextFieldValue())
    }

    Surface(
        color = Pink80

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Text Field to display username
            TextField(
                value = username,
                onValueChange = { newValue ->
                    username = newValue
                },
                label = { Text(text = "Nome") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Text Field to display entered password
            TextField(
                value = enteredPassword,
                onValueChange = { enteredPassword = it },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = "Senha") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Access Account Button
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(60.dp)

            ) {
                Text(text = "Acesse a sua conta")

            }
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    var passwordEntered by remember { mutableStateOf("") }
    LoginScreen(onLoginClicked = { password ->
        passwordEntered = password
    })
}