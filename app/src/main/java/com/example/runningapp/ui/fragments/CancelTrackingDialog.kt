package com.example.runningapp.ui.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.runningapp.R
import com.example.runningapp.db.Run
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog : DialogFragment() {

    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: () -> Unit) {
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setIcon(R.drawable.ic_delete)
                .setTitle(getString(R.string.cancel_tracking_dialog_title))
                .setMessage(getString(R.string.cancel_tracking_dialog_message))
                .setPositiveButton(getString(R.string.cancel_tracking_dialog_pos_button)) { _, _ ->
                    yesListener?.let { yes ->
                        yes()
                    }
                }
                .setNegativeButton(getString(R.string.cancel_tracking_dialog_neg_button)) { dialogInterface, _ ->
                    dialogInterface.cancel()
                }
                .create()
    }
}