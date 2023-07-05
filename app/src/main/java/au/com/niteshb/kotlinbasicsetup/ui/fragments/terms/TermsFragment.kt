package au.com.niteshb.kotlinbasicsetup.ui.fragments.terms

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.base.BaseFragment
import au.com.niteshb.kotlinbasicsetup.databinding.FragmentTermsBinding


class TermsFragment : BaseFragment<FragmentTermsBinding, TermsViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_terms
    override val viewModel: TermsViewModel
        get() = ViewModelProvider(this)[TermsViewModel::class.java]

    override fun initializeUI(
        view: View?,
        viewModel: TermsViewModel,
        binder: FragmentTermsBinding,
        savedInstanceState: Bundle?
    ) {
        binder.DoneButton.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_termsFragment_to_homeFragment)
        }
    }

}