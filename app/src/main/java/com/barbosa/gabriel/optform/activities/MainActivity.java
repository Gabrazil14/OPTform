package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.interfaces.OPTApi;
import com.barbosa.gabriel.optform.models.Session;
import com.barbosa.gabriel.optform.models.Supervisor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {
    private Session session;
    private Supervisor supervisor;
    private TextView welcomeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = MainApplication.getSession();
        if (!session.isValid()) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finishAffinity();
        } else {
            welcomeLabel = findViewById(R.id.welcome_label);
            showLoadingDialog(this);
            loadSupervisorData();
        }
    }

    private void loadSupervisorData() {
        Retrofit retrofit = MainApplication.getRetrofit(session.getInstanceUrl());
        OPTApi optApi = retrofit.create(OPTApi.class);
        Call<Supervisor> call = optApi.getSupervisor(session.getAccessToken());
        call.enqueue(new Callback<Supervisor>() {
            @Override
            public void onResponse(Call<Supervisor> call, Response<Supervisor> response) {
                if (response.isSuccessful()) {
                    supervisor = response.body();
                    welcomeLabel.setText(getString(R.string.welcome, supervisor.getName()));
                    hideLoadingDialog();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
                    hideLoadingDialog();
                }
            }

            @Override
            public void onFailure(Call<Supervisor> call, Throwable t) {
                Toast.makeText(MainActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
                hideLoadingDialog();
            }
        });
    }
}
