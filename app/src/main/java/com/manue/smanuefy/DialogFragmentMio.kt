package com.manue.smanuefy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.view.*

open class DialogFragmentMio : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        rootView.button7.setOnClickListener{
            Toast.makeText(context, "Has aceptado el diálogo", Toast.LENGTH_LONG).show()
            dismiss()
        }

        rootView.button8.setOnClickListener{
            dismiss()
        }

        return rootView
    }
}