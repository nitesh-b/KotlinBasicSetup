package au.com.niteshb.kotlinbasicsetup.viemodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.niteshb.kotlinbasicsetup.base.BaseViewModel

class VMDataBindingViewModel: BaseViewModel() {
    private var counter = MutableLiveData<Int>()

    val counterData : LiveData<Int>
        get() = counter

    fun updateCounter(){
        if(counter.value == null){
            counter.value = 0
        }
        counter.value?.let{
            counter.value = it.plus(1)
        }

    }


}