package au.com.niteshb.kotlinbasicsetup.viemodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.niteshb.kotlinbasicsetup.base.BaseViewModel

class MainViewModel(private val initValue: Int) : BaseViewModel() {
    private var total = MutableLiveData<Int>()

    //get() can be used to create getter
    val totalData: LiveData<Int>
        get() = total

    init {
        this.total.value = initValue
    }


    fun updateTotal(add: Int) {
        total.value = total.value?.plus(add)
    }
}