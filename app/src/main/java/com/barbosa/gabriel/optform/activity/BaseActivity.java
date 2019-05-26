package com.barbosa.gabriel.optform.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.barbosa.gabriel.optform.dialog.LoadingDialog;

public class BaseActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showLoadingDialog(Context context) {

        loadingDialog = new LoadingDialog(context);
        loadingDialog.show();

    }

    public void hideLoadingDialog() {

        if (loadingDialog != null)
            loadingDialog.dismiss();

    }
}
