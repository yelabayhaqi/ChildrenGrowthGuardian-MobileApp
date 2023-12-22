package com.dicoding.mybook_sc.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.project.childrenguardian.R
import com.project.childrenguardian.data.models.ChildrenModel
import com.project.childrenguardian.ui.theme.ChildrenGuardianTheme
import com.project.childrenguardian.ui.theme.green
import com.project.childrenguardian.ui.theme.white

val testChildrenList: List<ChildrenModel> = listOf(
    ChildrenModel("John", "Doe", 1, "2005-03-15", 1),
    ChildrenModel("Emma", "Smith", 2, "2008-08-22", 2),
    ChildrenModel("Liam", "Johnson", 1, "2010-05-10", 3),
    ChildrenModel("Olivia", "Williams", 2, "2013-12-03", 4),
    // Add more dummy data as needed
)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToHistory: (Long) -> Unit,
    navController: NavController
) {
    Column()
    {
        HomeTopAppBar(title = "Children Guardian", navController = navController)
        HomeContent(
            modifier = modifier,
            navigateToHistory = {},
            childrens = testChildrenList
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navigateToHistory: (Long) -> Unit,
    childrens: List<ChildrenModel>
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(childrens) { children ->
                CardItem(
                    id = children.childId,
                    name = children.firstname,
                    penulis = children.lastname,
                    dob = children.dob,
                    gender = if (children.gender == 1) "Male" else "Female",
                    modifier = modifier,
                    navigateToHistory = navigateToHistory
                )
            }
        }
        FloatingActionButton(
            onClick = {
                // Handle FAB click
            },
            backgroundColor = green,
            modifier = Modifier
                .padding(16.dp)
                .size(56.dp)
                .align(Alignment.End),
            contentColor = Color.White, // Customize FAB content color
            elevation = FloatingActionButtonDefaults.elevation(8.dp) // Customize FAB elevation
        ) {
            // FAB icon or content
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier.size(32.dp),
                tint = white
            )
        }
    }
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    id: Long = 1,
    name: String,
    penulis: String,
    navigateToHistory: (Long) -> Unit,
    gender: String,
    dob: String
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navigateToHistory(id)
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Column(
                modifier = modifier.weight(4f)
            ) {
                Text(
                    text = "$name $penulis",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold))
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Date of Birth : $dob, Gender : $gender",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        color = Color.Gray
                    ),
                    modifier = Modifier.padding(top = 12.dp),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    title: String,
    navController: NavController
) {
    TopAppBar(
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    ChildrenGuardianTheme {
        HomeScreen(
            navController = navController,
            navigateToHistory = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    ChildrenGuardianTheme {
        CardItem(
            id = 1,
            name = "John",
            penulis = "Doe",
            gender = "Male",
            dob = "2005-03-15",
            navigateToHistory = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTopAppBarPreview() {
    ChildrenGuardianTheme {
        HomeTopAppBar(
            title = "Children Guardian",
            navController = rememberNavController()
        )
    }
}
