package com.project.childrenguardian.screens.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dicoding.mybook_sc.screens.home.HomeTopAppBar
import com.project.childrenguardian.R
import com.project.childrenguardian.data.models.ChildrenModel
import com.project.childrenguardian.data.models.HistoryModel
import com.project.childrenguardian.di.Injection
import com.project.childrenguardian.screens.UiState
import com.project.childrenguardian.screens.ViewModelFactory
import com.project.childrenguardian.ui.theme.ChildrenGuardianTheme
import com.project.childrenguardian.ui.theme.lightGreen


val testHistoryList: List<HistoryModel> = listOf(
    HistoryModel(1, 9.97, "Normal", "Sun, 25 Apr 2021 00:00:00 GMT", 93.85, 8.78)
    // Add more dummy data as needed
)

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column() {
        HomeTopAppBar(title = "History", navController = navController)
        HistoryContent(
            modifier = modifier,
            historyList = testHistoryList
        )
    }
}

@Composable
fun HistoryContent(
    modifier: Modifier = Modifier,
    historyList: List<HistoryModel>
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(historyList) { history ->
                HistoryItem(
                    age = history.age,
                    bmi = history.bmi,
                    checkResult = history.checkResult,
                    checkedAt = history.checkedAt,
                    height = history.height,
                    weight = history.weight
                )
            }
        }
    }
}

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    age: Int,
    bmi: Double,
    checkResult: String,
    checkedAt: String,
    height: Double,
    weight: Double
) {
    Row(){
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold))
            ),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
        Button(
            onClick = {},
        ) {
            Text(
                text = "Add New Data",
                fontSize = 14.sp
            )
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Text(
                text = "Sunday, 23 June 2023",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold))
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Age: $age Years Old",
                style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                color = Color.Gray
            ),
            modifier = Modifier.padding(top = 4.dp),
            )
            Text(
                text = "BMI: $bmi",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 4.dp),
            )
            Text(
                text = "Check Result: $checkResult",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 4.dp),
            )
            Text(
                text = "Height: $height",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 4.dp),
            )
            Text(
                text = "Weight: $weight",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 4.dp),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HistoryScreenPreview() {
    val navController = rememberNavController()
    ChildrenGuardianTheme {
        HistoryScreen(navController = navController)
    }
}

@Composable
@Preview(showBackground = true)
fun HistoryItemPreview() {
    ChildrenGuardianTheme {
        HistoryItem(
            age = 1,
            bmi = 9.97,
            checkResult = "Normal",
            checkedAt = "Sun, 25 Apr 2021 00:00:00 GMT",
            height = 93.85,
            weight = 8.78
        )
    }
}