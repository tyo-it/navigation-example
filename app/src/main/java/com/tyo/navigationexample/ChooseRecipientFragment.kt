package com.tyo.navigationexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        next_btn.setOnClickListener {

            if (!TextUtils.isEmpty(input_recipient.text.toString())) {
                val bundle = bundleOf("recipient" to input_recipient.text.toString())
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
            }
        }
        cancel_btn.setOnClickListener { navController.navigateUp() }
    }

}
