package com.project.childrenguardian.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.childrenguardian.ui.theme.ChildrenGuardianTheme

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Children Growth",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        )

        Text(
            text = "Guardian",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Text(
            text = "Child stunting detection platform and child nutrition guidance for mother.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Text(
            text = "Register",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
                .align(Alignment.Start)
        )

        Text(
            text = "Name",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("enter your name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Email",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("enter your email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Password",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("enter your password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = onRegisterClick,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Register",
                fontSize = 26.sp
            )
        }

        TextButton(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    ChildrenGuardianTheme {
        RegisterScreen(
            onRegisterClick = {},
            onBackClick = {}
        )
    }
}