package com.android.rahul.nirmesh.communicatingwithuser;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG="AUC-SNACKBAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        findViewById(R.id.btnShowSnackbar).setOnClickListener(this);
        findViewById(R.id.btnShowActionSnackbar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowSnackbar:
                showSnackbar();
                break;
            case R.id.btnShowActionSnackbar:
                showActionSnackbar();
                break;
        }
    }

    private void showSnackbar() {
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                "This is a Snackbar",
                Snackbar.LENGTH_LONG
        );
        snackbar.show();
    }

    private void showActionSnackbar() {
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                "This is a Snackbar",
                Snackbar.LENGTH_LONG
        );

        snackbar.setAction("My Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackbarActivity.this, "Toast via Snackbar Action", Toast.LENGTH_SHORT).show();
            }
        });

        snackbar.setActionTextColor(Color.RED);

        snackbar.show();
    }
}
