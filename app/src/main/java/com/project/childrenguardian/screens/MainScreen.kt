package com.project.childrenguardian.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.foodinfo.ui.navigation.Routes
import com.dicoding.mybook_sc.screens.home.HomeScreen
import com.project.childrenguardian.screens.aboutus.AboutUsScreen
import com.project.childrenguardian.screens.auth.LoginScreen
import com.project.childrenguardian.screens.auth.RegisterScreen
import com.project.childrenguardian.screens.childrendata.AddChildrenScreen
import com.project.childrenguardian.screens.childrendata.AddHistoryScreen
import com.project.childrenguardian.screens.components.BottomNav
import com.project.childrenguardian.screens.details.DetailsScreen
import com.project.childrenguardian.screens.home.HistoryScreen
import com.project.childrenguardian.screens.welcomescreen.WelcomeScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if ((currentRoute != Routes.Welcome.route)&&(currentRoute != Routes.Login.route)&&(currentRoute != Routes.Register.route)) {
                BottomNav(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController,
            startDestination = Routes.Welcome.route,
        ) {
            composable(Routes.Welcome.route) {
                WelcomeScreen(
                    onLoginClick = { navController.navigate(Routes.Login.route) },
                    onRegisterClick = { navController.navigate(Routes.Register.route) }
                )
            }
            composable(Routes.Login.route) {
                LoginScreen(
                    onLoginClick = { navController.navigate(Routes.Home.route) },
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Routes.Register.route) {
                RegisterScreen(
                    onRegisterClick = { navController.navigate(Routes.Login.route) },
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Routes.Home.route) {
//                HomeScreen(
//                    navigateToHistory = { id ->
//                        navController.navigate(Routes.History.route)
//                    },
//                    navController = navController
//                )

                AddHistoryScreen(
                    onLoginClick = { navController.navigate(Routes.Home.route) },
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Routes.History.route) {
                HistoryScreen(navController = navController)
            }
            composable(Routes.Details.route) {
                DetailsScreen()
            }

            composable(Routes.AboutUs.route) {
                AboutUsScreen(
                    onBackClick = {
                        navController.navigateUp()
                    },
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
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}