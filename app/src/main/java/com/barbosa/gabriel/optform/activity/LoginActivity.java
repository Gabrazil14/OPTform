package com.barbosa.gabriel.optform.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.barbosa.gabriel.optform.Interface.SalesForceLoginApi;
import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.model.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends BaseActivity {

    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.user_name_text);
        password = findViewById(R.id.user_password);
        Button login = findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingDialog(LoginActivity.this);
                Retrofit retrofit = MainApplication.getRetrofit(SalesForceLoginApi.loginUrl);
                SalesForceLoginApi loginApi = retrofit.create(SalesForceLoginApi.class);
                Call<Session> call = loginApi.login("password",
                        "3MVG9ZF4bs_.MKug78PunwIbV3anh9yu_vTv6ifsF0L2GJTTpAA1qBdWRQ3I8aHZYDqVfAo_xOl7MK8Is27Ho",
                        "CF0025345F3A6B3FB2A8254426B931BAF560C20C82FEA8407353DE54A614F4EA",
                        userName.getText().toString(),
                        password.getText().toString());

                call.enqueue(new Callback<Session>() {
                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {
                        if (response.isSuccessful()) {
                            Session session = response.body();

                            ((MainApplication) getApplication()).saveSession(session);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            hideLoadingDialog();
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
                            hideLoadingDialog();
                        }

                    }

                    @Override
                    public void onFailure(Call<Session> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
                        hideLoadingDialog();
                    }
                });
            }
        });


    }
}
