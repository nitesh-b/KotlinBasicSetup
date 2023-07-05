package au.com.niteshb.kotlinbasicsetup.ui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseActivity
import au.com.niteshb.kotlinbasicsetup.databinding.ActivityMainBinding
import au.com.niteshb.kotlinbasicsetup.viemodels.MainViewModel
import au.com.niteshb.kotlinbasicsetup.viemodels.MainViewModelFactory

class AddActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this,
            MainViewModelFactory(20))[MainViewModel::class.java]


    override fun initializeUI(
        viewModel: MainViewModel,
        binder: ActivityMainBinding,
        savedInstanceState: Bundle?
    ) {
        viewModel.totalData.observe(this) {
            binder.countTextView.text = it.toString()
        }
        binder.actionButton.setOnClickListener {
            val intValue : Int
            val additionValue: String = binder.inputEditText.text.toString()
            intValue = try{
                Integer.valueOf(additionValue)
            }catch( ex: Exception){
                0
            }
            this.viewModel.updateTotal(intValue)
            binder.inputEditText.text.clear()
        }

    }

}
