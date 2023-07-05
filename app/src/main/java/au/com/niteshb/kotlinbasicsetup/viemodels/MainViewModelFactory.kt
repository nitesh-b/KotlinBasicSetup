package au.com.niteshb.kotlinbasicsetup.viemodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val initValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel:: class.java)){
            return MainViewModel(initValue = initValue) as T
        }
        throw IllegalArgumentException("Unknown VM class")
    }

}