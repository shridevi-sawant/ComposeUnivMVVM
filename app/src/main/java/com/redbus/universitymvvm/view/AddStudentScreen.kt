package com.redbus.universitymvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.redbus.universitymvvm.viewModel.StudentViewModel


@Composable
fun AddStudentScreen(stdModel: StudentViewModel,
                     addAction: () -> Unit){
    
    var name by remember { 
        mutableStateOf("")
    }

    var id by remember {
        mutableStateOf("")
    }

    var marks by remember {
        mutableStateOf("")
    }


    Surface(color = Color.Yellow) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = name , onValueChange = {
                name = it
            }, label =  {
                Text("Student Name")
            })
            
            Spacer(modifier = Modifier.size(40.dp))

            OutlinedTextField(value = id , onValueChange = {
                id = it
            }, label =  {
                Text("Student Roll Number")
            })

            Spacer(modifier = Modifier.size(40.dp))

            OutlinedTextField(value = marks , onValueChange = {
                marks = it
            }, label =  {
                Text("Student Percentage")
            })

            Spacer(modifier = Modifier.size(40.dp))
            
            Button(onClick = {
                stdModel.addNewStudent(name, id.toInt(), marks.toInt())
                addAction()

            }) {
                Text(text = "Add Student")
            }


        }
    }
}
