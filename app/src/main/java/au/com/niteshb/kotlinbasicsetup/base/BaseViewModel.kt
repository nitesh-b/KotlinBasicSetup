package au.com.niteshb.kotlinbasicsetup.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val TAG: String = this.javaClass.name
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = loading

    val startRequest: MutableLiveData<Boolean> = MutableLiveData()
    val onResponseSuccessful: MutableLiveData<Boolean> = MutableLiveData()
    val onResponseFailed: MutableLiveData<String> = MutableLiveData()
    val onError: MutableLiveData<Error> = MutableLiveData()
    val onTokenExpired: MutableLiveData<String> = MutableLiveData()
    val onWarning: MutableLiveData<String> = MutableLiveData()
    val onLogoutSuccess: MutableLiveData<Boolean> = MutableLiveData()




    init {
        this.loading.value = false
    }

}
