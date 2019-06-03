package com.barbosa.gabriel.optform.activities;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.barbosa.gabriel.optform.dialogs.LoadingDialog;

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
