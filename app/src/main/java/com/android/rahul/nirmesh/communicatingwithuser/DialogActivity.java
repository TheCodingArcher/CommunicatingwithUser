package com.android.rahul.nirmesh.communicatingwithuser;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.android.rahul.nirmesh.communicatingwithuser.Dialogs.CustomDialogFragment;
import com.android.rahul.nirmesh.communicatingwithuser.Dialogs.SimpleDialogFragment;
import com.android.rahul.nirmesh.communicatingwithuser.Dialogs.SingleChoiceDialogFragment;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "AUC_DLG_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // set up button click handlers
        findViewById(R.id.btnSimpleDialog).setOnClickListener(this);
        findViewById(R.id.btnShowDatePicker).setOnClickListener(this);
        findViewById(R.id.btnShowChoiceDialog).setOnClickListener(this);
        findViewById(R.id.btnShowCustomDialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSimpleDialog:
                showSimpleDialog();
                break;
            case R.id.btnShowDatePicker:
                // TODO: Get a calendar instance
                Calendar calendar = Calendar.getInstance();

                // TODO: Create a DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        Log.i(TAG, String.format("Date chosen: day: %d, month: %d, year: %d", day, month + 1, year));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                // TODO: Set the title and show the dialog
                datePickerDialog.setTitle("Choose a Date");
                datePickerDialog.show();
                break;
            case R.id.btnShowChoiceDialog:
                showChoiceDialog();
                break;
            case R.id.btnShowCustomDialog:
                showCustomDialog();
                break;
        }
    }

    private void showSimpleDialog() {
        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();

        // TODO: Use setCancelable() to make the dialog non-cancelable
        simpleDialog.setCancelable(false);

        simpleDialog.show(getSupportFragmentManager(), "SimpleDialogFragment");
    }

    private void showCustomDialog() {
        CustomDialogFragment customDialog = new CustomDialogFragment();
        customDialog.show(getSupportFragmentManager(), "CustomDialogFragment");
    }

    private void showChoiceDialog() {
        SingleChoiceDialogFragment complexDialog = new SingleChoiceDialogFragment();
        complexDialog.show(getSupportFragmentManager(),"SingleChoiceDialogFragment");
    }

    //TODO: implement dialog listener interface functions
}
