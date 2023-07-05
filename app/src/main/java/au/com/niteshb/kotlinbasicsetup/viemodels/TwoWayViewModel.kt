package au.com.niteshb.kotlinbasicsetup.viemodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.niteshb.kotlinbasicsetup.base.BaseViewModel

class TwoWayViewModel: BaseViewModel() {
    val userName = MutableLiveData<String>()

    init {
        this.userName.value = "Nitesh"
    }

}