package au.com.niteshb.kotlinbasicsetup.ui.fragments.home

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseFragment
import au.com.niteshb.kotlinbasicsetup.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun initializeUI(
        view: View?,
        viewModel: HomeViewModel,
        binder: FragmentHomeBinding,
        savedInstanceState: Bundle?
    ) {
        binder.lifecycleOwner = this
        binder.viewModel = viewModel

        binder.button.setOnClickListener{
            if(!TextUtils.isEmpty(binder.editText.text.toString())){
                val bundle = bundleOf("user_name" to binder.editText.text.toString())
                requireView().findNavController().navigate(R.id.action_homeFragment_to_languageFragment, bundle)
            }else{
                Toast.makeText(activity, "Please enter text", Toast.LENGTH_SHORT).show()
            }
        }

        binder.tocButton.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_homeFragment_to_termsFragment)
        }

        }


    }
