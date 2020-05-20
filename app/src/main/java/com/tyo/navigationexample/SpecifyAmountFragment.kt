package com.tyo.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.cancel_btn
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 * Use the [SpecifyAmountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecifyAmountFragment : Fragment() {

    lateinit var recipientName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments!!.getString("recipient")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        recipient.text = "sending money to $recipientName"

        send_btn.setOnClickListener {
            val amount = Money(BigDecimal(input_amount.text.toString()))
            val bundle = bundleOf("recipient" to recipientName, "amount" to amount)
            navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
        }
        cancel_btn.setOnClickListener { navController.navigateUp() }
    }
}
