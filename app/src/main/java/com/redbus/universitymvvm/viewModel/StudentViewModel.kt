package com.redbus.universitymvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.redbus.universitymvvm.model.Repository
import com.redbus.universitymvvm.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
   1. Reference to repo
   2. No reference of view
   3. All data required in view should be hold in VM
 */
class StudentViewModel(application: Application) : ViewModel() {

    val repo = Repository(application)

    var stdList = mutableStateOf(repo.getAllStudents())

    var isStdAdded = MutableLiveData<Boolean>(false)

    fun addNewStudent(name: String, id: Int, marks: Int){
        viewModelScope.launch(Dispatchers.IO) {
            if (repo.addStudent(Student(id, name, marks))){
                isStdAdded.postValue(true)
            }
            else
                isStdAdded.postValue(false)
        }

    }


}


class StdVMFactory(val app: Application): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StudentViewModel(app) as T
    }
}
