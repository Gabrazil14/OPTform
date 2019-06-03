package com.barbosa.gabriel.optform.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.Window;

import com.barbosa.gabriel.optform.R;

public class LoadingDialog extends Dialog {


    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(false);

    }

}
