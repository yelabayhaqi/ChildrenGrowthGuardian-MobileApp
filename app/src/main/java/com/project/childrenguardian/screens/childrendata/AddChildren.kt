package com.project.childrenguardian.screens.childrendata

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
fun AddChildrenScreen(
    onLoginClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Children",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
                .align(Alignment.Start)
        )

        Text(
            text = "First Name",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("enter firstname") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Last Name",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("enter lastname") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Date of Birth",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("dd/mm/yyyy") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Gender",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Select Gender") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Save",
                fontSize = 26.sp
            )
        }

        TextButton(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 22.dp)
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
fun LoginScreenPreview() {
    ChildrenGuardianTheme {
        AddChildrenScreen(
            onLoginClick = {},
            onBackClick = {}
        )
    }
}