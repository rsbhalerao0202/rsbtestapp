package com.example.fourrwallsrsbtestapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


class ExitFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exit, container, false)
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        dialogBuilder
            // if the dialog is cancelable
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
                getActivity()?.finish()


            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
                startActivity(Intent(requireActivity(), MainActivity::class.java))

            })

        val alert = dialogBuilder.create()
        alert.setTitle("Want to exit app?")
        alert.show()
//        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        return view
    }

    override fun onDetach() {
        super.onDetach()
//        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}
