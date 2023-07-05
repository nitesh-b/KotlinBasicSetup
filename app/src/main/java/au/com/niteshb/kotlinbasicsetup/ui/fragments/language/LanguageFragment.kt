package au.com.niteshb.kotlinbasicsetup.ui.fragments.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseFragment
import au.com.niteshb.kotlinbasicsetup.databinding.FragmentLanguageBinding

class LanguageFragment : BaseFragment<FragmentLanguageBinding, LanguageViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_language
    override val viewModel: LanguageViewModel
        get() = ViewModelProvider(this).get(LanguageViewModel::class.java)

    override fun initializeUI(
        view: View?,
        viewModel: LanguageViewModel,
        binder: FragmentLanguageBinding,
        savedInstanceState: Bundle?
    ) {
        arguments?.let {
            binder.nameTextView.text = it.getString("user_name")
        }

        binder.submitButton.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_languageFragment_to_permissionFragment, arguments)
        }
    }


}