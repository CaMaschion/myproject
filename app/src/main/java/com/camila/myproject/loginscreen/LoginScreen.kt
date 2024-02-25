package com.camila.myproject.loginscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.camila.myproject.R
import com.camila.myproject.ui.theme.Green80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClicked: (String) -> Unit) {

    val contexto = LocalContext.current

    var showSnackbar by remember {
        mutableStateOf(false)
    }

    var username by remember {
        mutableStateOf(TextFieldValue())
    }

    var enteredPassword by remember {
        mutableStateOf(TextFieldValue())
    }

    Surface(
        color = Green80
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_money),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(200.dp) // Adjust the size of the image as needed
                    .padding(bottom = 16.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = {
                    Text(
                        text = "Nome",
                        color = Black
                    )
                },
                singleLine = true,
                isError = false,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Black,
                    focusedBorderColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = enteredPassword,
                onValueChange = { enteredPassword = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = {
                    Text(
                        text = "Senha",
                        color = Black
                    )
                },
                singleLine = true,
                isError = false,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Black,
                    focusedBorderColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextButton(
                onClick = {
                    Toast.makeText(contexto, "ok", Toast.LENGTH_SHORT).show()
                },

                colors = ButtonDefaults.buttonColors(
                    contentColor = Black,
                    containerColor = Green80
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Start)

            ) {
                Text("Esqueci minha senha")
            }

            Spacer(modifier = Modifier.height(16.dp))

            RandomKeyboard()

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Black),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(60.dp),

                ) {
                Text(text = "Acessar")
            }

        }

    }

}

@Composable
private fun RandomKeyboard() {

    Row {

        for (i in 0..2) {
            CreateRandomButton()

            Spacer(modifier = Modifier.padding(5.dp))
        }

    }

    Row {

        for (i in 0..1) {
            CreateRandomButton()

            Spacer(modifier = Modifier.padding(5.dp))
        }

        ClearButton()

    }
}

@Composable
private fun ClearButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Black),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .height(50.dp),

        ) {
        Text(text = "Limpar")

    }
}

@Composable
private fun CreateRandomButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Black),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .height(50.dp)

    ) {
        Text(text = "1 ou 2")

    }
}

@Composable
private fun NumericRandomButton() {

}


@Preview
@Composable
fun LoginScreenPreview() {
    var passwordEntered by remember { mutableStateOf("") }
    LoginScreen(onLoginClicked = { password ->
        passwordEntered = password
    })
}