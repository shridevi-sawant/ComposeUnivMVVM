package com.redbus.universitymvvm.view

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.redbus.universitymvvm.viewModel.StudentViewModel
import kotlin.reflect.typeOf


@Composable
fun AppNavigation(viewModel: StudentViewModel){
    /*
    navController
    NavHost
    navigate
     */

    val appNavController = rememberNavController()

    NavHost(navController = appNavController,
        startDestination = "student_list"){

        composable("student_list"){
            StdListScreen(stdModel = viewModel){
                appNavController.navigate("add_screen")
            }
        }

        composable("add_screen"){

            AddStudentScreen(stdModel = viewModel){

                if (!appNavController.popBackStack()){
                    appNavController.navigate("student_list")
                }
            }
        }
    }


}