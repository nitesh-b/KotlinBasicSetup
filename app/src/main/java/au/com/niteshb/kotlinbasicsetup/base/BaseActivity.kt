package au.com.niteshb.kotlinbasicsetup.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import au.com.niteshb.kotlinbasicsetup.R

abstract class BaseActivity<T : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var binder: T
    private lateinit var progressBar: ProgressBar
    private lateinit var mViewModel: VM

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract val viewModel: VM

    protected abstract fun initializeUI(viewModel: VM, binder: T, savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtain the current Window
        val window: Window = window
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        // Set the status bar color to statusbar color
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBar)
        mViewModel = viewModel
        setContentView(layoutRes)
    }

    override fun setContentView(layoutResID: Int) {
        val coordinatorLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as CoordinatorLayout
        val activityContainer = coordinatorLayout.findViewById<FrameLayout>(R.id.layout_container)
        binder = DataBindingUtil.inflate(layoutInflater, layoutResID, activityContainer, true)
        binder.lifecycleOwner = this
        super.setContentView(coordinatorLayout)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initializeUI(mViewModel, binder, savedInstanceState)
        subscribeObserver()
    }

    @CallSuper
    private fun subscribeObserver() {
        mViewModel.startRequest.observe(this) {
            mViewModel.loading.value = true
            Toast.makeText(this, "Request Started", Toast.LENGTH_SHORT).show()
        }
        mViewModel.onResponseSuccessful.observe(this) {
            mViewModel.loading.value = false
            Toast.makeText(this, "Response is successful", Toast.LENGTH_SHORT).show()
        }
        mViewModel.onResponseFailed.observe(this) {
            mViewModel.loading.value = false
            Toast.makeText(this, "Response is successful", Toast.LENGTH_SHORT).show()
        }
        mViewModel.onWarning.observe(this){
            if (it != null && it == "") {
                mViewModel.onWarning.value = null
            }
        }
        mViewModel.onError.observe(this)  {
            if (it != null ) {
                mViewModel.onError.value = null
            }
        }
    }
}