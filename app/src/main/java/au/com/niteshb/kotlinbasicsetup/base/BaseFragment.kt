package au.com.niteshb.kotlinbasicsetup.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    var TAG = this.javaClass.name

    @JvmField
    protected var mContext: Context? = null
    @JvmField
    protected var binder: T? = null

    private var mActivity: BaseActivity<*, *>? = null
    private var mViewModel: VM? = null
    private var rootView: View? = null

    @get:LayoutRes
    abstract val layoutResID: Int
    abstract val viewModel: VM
    val dataBinder: T?
        get() = binder

    override fun onAttach(context: Context) {
        try {
            mContext = context
            super.onAttach(context)
            if (context is BaseActivity<*, *>) {
                mActivity = context
            }
        } catch (e: Throwable) {
            throw ClassCastException("\$context must implement FragmentListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate(inflater, layoutResID, container, false)
        binder!!.lifecycleOwner = viewLifecycleOwner
        rootView = binder!!.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            subscribeObserver(mViewModel)
            initializeUI(view, mViewModel!!, binder!!, savedInstanceState)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    @CallSuper
    private fun subscribeObserver(mViewModel: VM?) {
        mViewModel?.let {
            it.apply {
                startRequest.observe(viewLifecycleOwner) {
                    loading.value = true
                    Toast.makeText(context, "Request Started", Toast.LENGTH_SHORT).show()
                }
                onResponseSuccessful.observe(viewLifecycleOwner) {
                    loading.value = false
                    Toast.makeText(context, "Response is successful", Toast.LENGTH_SHORT).show()
                }
                onResponseFailed.observe(viewLifecycleOwner) {
                    loading.value = false
                    Toast.makeText(context, "Response is successful", Toast.LENGTH_SHORT).show()
                }
                onWarning.observe(viewLifecycleOwner){
                    if (it != null && it == "") {
                        onWarning.value = null
                    }
                }
                onError.observe(viewLifecycleOwner)  {
                    if (it != null ) {
                        onError.value = null
                    }
                }
            }
        }

    }

    protected abstract fun initializeUI(
        view: View?,
        viewModel: VM,
        binder: T,
        savedInstanceState: Bundle?
    )
}