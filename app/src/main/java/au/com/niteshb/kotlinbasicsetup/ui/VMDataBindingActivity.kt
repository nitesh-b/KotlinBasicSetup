package au.com.niteshb.kotlinbasicsetup.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseActivity
import au.com.niteshb.kotlinbasicsetup.databinding.ActivityVmdataBindingBinding
import au.com.niteshb.kotlinbasicsetup.viemodels.VMDataBindingViewModel
/*Data bindng with viewModel and live data. Refer to XML file as well*/
class VMDataBindingActivity : BaseActivity<ActivityVmdataBindingBinding, VMDataBindingViewModel>() {

    override val layoutRes: Int
        get() = R.layout.activity_vmdata_binding
    override val viewModel: VMDataBindingViewModel
        get() = ViewModelProvider(this)[VMDataBindingViewModel::class.java]


    override fun initializeUI(
        viewModel: VMDataBindingViewModel,
        binder: ActivityVmdataBindingBinding,
        savedInstanceState: Bundle?
    ) {
        binder.viewModel = viewModel
    }
}