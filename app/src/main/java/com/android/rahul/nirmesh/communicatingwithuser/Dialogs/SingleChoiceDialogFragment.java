package com.android.rahul.nirmesh.communicatingwithuser.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class SingleChoiceDialogFragment extends DialogFragment {

    private final String TAG = "AUC_COMPLEX";

    // List of choices to display in the dialog
    private final String[] colors = {"Red", "Blue", "Green", "Yellow"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("What Is Your Favorite Color?");

        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                Log.i(TAG, String.format("Color chosen: %s", colors[position]));
            }
        });

        return builder.create();
    }
}
