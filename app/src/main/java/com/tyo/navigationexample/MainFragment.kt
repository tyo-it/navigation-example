package com.tyo.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        send_money_btn.setOnClickListener { navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment) }
        view_balance_btn.setOnClickListener { navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment) }
        view_transactions_btn.setOnClickListener { navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment) }
    }

}
