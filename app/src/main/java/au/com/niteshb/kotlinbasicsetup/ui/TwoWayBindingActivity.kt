package au.com.niteshb.kotlinbasicsetup.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseActivity
import au.com.niteshb.kotlinbasicsetup.databinding.ActivityTwoWayBindingBinding
import au.com.niteshb.kotlinbasicsetup.viemodels.TwoWayViewModel
/*In two way data binding whenever we change the view, object is updated and when also when object is
* updated, view is updated as well
* Eg: Implement TextView and editText
* changes in editText are reflected in textVIew without using textWatcher. We are using viewModel*/
class TwoWayBindingActivity : BaseActivity<ActivityTwoWayBindingBinding,TwoWayViewModel >() {

    override val layoutRes: Int
        get() = R.layout.activity_two_way_binding

    override val viewModel: TwoWayViewModel
        get() = ViewModelProvider(this)[TwoWayViewModel::class.java]

    override fun initializeUI(
        viewModel: TwoWayViewModel,
        binder: ActivityTwoWayBindingBinding,
        savedInstanceState: Bundle?
    ) {

        binder.lifecycleOwner = this
        binder.viewModel = viewModel
    }
}