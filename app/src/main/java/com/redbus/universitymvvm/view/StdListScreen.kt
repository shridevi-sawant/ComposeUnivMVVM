package com.redbus.universitymvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redbus.universitymvvm.model.Student
import com.redbus.universitymvvm.viewModel.StudentViewModel

@Composable
fun StdListScreen(stdModel: StudentViewModel,
                  fabClicked: () -> Unit){

    val stdListState = stdModel.stdList.value.observeAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                fabClicked()
            }) {
                Icon(Icons.Filled.Add, "add FAB")
            }
    }) {


        Surface(color = Color.Gray, modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {

                stdListState.value?.let {
                    items(it) { std ->
                        StudentItem(std = std)
                    }
                }
            }
        }
    }
}

@Composable
fun StudentItem(std: Student){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Cyan
        ),
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "${std.id}", fontSize = 30.sp,
                modifier = Modifier.padding(horizontal = 10.dp))
            Text(text = "${std.name}", fontSize = 40.sp, color = Color.Magenta,
                modifier = Modifier.padding(horizontal = 20.dp))
            Text(text = "${std.marks} %", fontSize = 30.sp,
                modifier = Modifier.padding(horizontal = 10.dp))
        }
    }
}