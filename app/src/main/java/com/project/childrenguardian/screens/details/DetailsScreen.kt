package com.project.childrenguardian.screens.details

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.project.childrenguardian.R
import com.project.childrenguardian.di.Injection
import com.project.childrenguardian.screens.UiState
import com.project.childrenguardian.screens.ViewModelFactory
import com.project.childrenguardian.ui.theme.lightGreen

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
) {
    DetailContent(
        name = "John Doe",
        age = "1 Year 6 Months Old",
        category = "Normal",
        height = 80,
        weight = 13.2,
        gender = "Male",
        dob = "13 June 2022",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
    name: String,
    age: String,
    category: String,
    height: Int,
    weight: Double,
    gender: String,
    dob: String,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .fillMaxWidth(),
        topBar = {
            DetailTopAppBar(title = "Details Information", onBackPressed = {})
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(top = 24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
            }
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                androidx.compose.material.Text(
                    text = name,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_bold)
                    ),
                    fontSize = 18.sp
                )
                androidx.compose.material.Text(
                    text = age,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_regular)
                    ),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                androidx.compose.material.Text(
                    text = "Category",
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_bold)
                    ),
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                androidx.compose.material.Text(
                    text = category,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_light)
                    ),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Justify
                )
            }
            Text(
                text = "Detail Information",
                fontFamily = FontFamily(
                    Font(R.font.montserrat_bold)
                ),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Height",
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_medium)
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = "$height",
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_light)
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Weight",
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_medium)
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = weight.toString(),
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_light)
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        color = Color.Black
                    )
                }
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Gender",
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_medium)
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = gender,
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_light)
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Date of Birth",
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_medium)
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = dob,
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_light)
                        ),
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        color = Color.Black
                    )
                }
            }
            Text(
                text = "Suggestion",
                fontFamily = FontFamily(
                    Font(R.font.montserrat_bold)
                ),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                color = Color.Black
            )
            Text(
                text = "\n" +
                        "Your kids are in a very good condition, but here are some general suggestions to keep healthy growth and prevent stunting for a 1 year and 6 months old baby :\n" +
                        "\n" +
                        "1. Balanced Nutrition:\n" +
                        "Ensure a well-balanced diet that includes a variety of foods from all food groups.\n" +
                        "Provide a mix of fruits, vegetables, grains, proteins, and dairy products.\n" +
                        "Breastfeeding or providing age-appropriate formula is still important for nutrition.\n" +
                        "\n" +
                        "2. Regular Health Check-ups:\n" +
                        "Schedule regular check-ups with a pediatrician to monitor the baby's growth and development.\n" +
                        "Discuss any concerns about nutrition, feeding habits, or developmental milestones.\n" +
                        "\n" +
                        "3. Adequate Protein Intake:\n" +
                        "Include good sources of protein in the baby's diet, such as lean meats, poultry, fish, eggs, dairy products, and plant-based proteins.\n" +
                        "\n" +
                        "4. Introduction of New Textures:\n" +
                        "Gradually introduce a variety of textures and flavors to encourage the development of chewing and swallowing skills.\n" +
                        "\n" +
                        "5. Encourage Physical Activity:\n" +
                        "Allow for supervised playtime and physical activity to support overall development.\n" +
                        "Encourage crawling, walking, and exploring the environment.\n" +
                        "\n" +
                        "6. Ensure Hydration:\n" +
                        "Provide sufficient water throughout the day to maintain hydration.\n" +
                        "Limit Sugary and Processed Foods:\n" +
                        "Minimize the intake of sugary snacks, sweets, and processed foods.\n" +
                        "\n" +
                        "7. Good Sleep Routine:\n" +
                        "Establish a consistent and healthy sleep routine to support overall well-being.\n" +
                        "\n" +
                        "8. Responsive Feeding:\n" +
                        "Pay attention to the baby's hunger and fullness cues during feeding.\n" +
                        "Encourage self-feeding when appropriate.\n" +
                        "\n" +
                        "9. Emotional Support:\n" +
                        "Provide a nurturing and stimulating environment.\n" +
                        "Respond to the baby's emotional needs promptly.",
                fontFamily = FontFamily(
                    Font(R.font.montserrat_light)
                ),
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                color = Color.Black
            )
            Button(
                onClick = {},
                enabled = false,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 25.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = lightGreen,
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "CONSULT TO SPECIALIST (coming soon)",
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_extra_bold)
                    ),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopAppBar(
    title: String,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_bold)
                    ),
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    DetailContent(
        name = "John Doe",
        age = "1.2 Years Old",
        category = "Normal",
        height = 80,
        weight = 13.2,
        gender = "Male",
        dob = "13 June 2022"
    )
}

