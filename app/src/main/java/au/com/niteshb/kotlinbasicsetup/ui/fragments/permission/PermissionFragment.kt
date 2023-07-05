package au.com.niteshb.kotlinbasicsetup.ui.fragments.permission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseFragment
import au.com.niteshb.kotlinbasicsetup.databinding.FragmentLanguageBinding
import au.com.niteshb.kotlinbasicsetup.databinding.FragmentPermissionBinding
import au.com.niteshb.kotlinbasicsetup.ui.fragments.language.LanguageViewModel

class PermissionFragment : BaseFragment<FragmentPermissionBinding, PermissionViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_permission
    override val viewModel: PermissionViewModel
        get() = ViewModelProvider(this).get(PermissionViewModel::class.java)


    override fun initializeUI(
        view: View?,
        viewModel: PermissionViewModel,
        binder: FragmentPermissionBinding,
        savedInstanceState: Bundle?
    ) {
        arguments?.let {
            binder.nameTextView.text = it.getString("user_name")
        }

        binder.submitButton.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_permissionFragment_to_termsFragment, arguments)
        }
    }


}