package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.interfaces.SalesForceLoginApi;
import com.barbosa.gabriel.optform.models.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(SalesForceLoginApi.LOGIN_URL)
                        .build();

                SalesForceLoginApi loginApi = retrofit.create(SalesForceLoginApi.class);
                Call<Session> call = loginApi.login("password",
                        SalesForceLoginApi.CLIENT_ID,
                        SalesForceLoginApi.CLIENT_SECRET,
                        userName.getText().toString(),
                        password.getText().toString());

                call.enqueue(new Callback<Session>() {
                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {
                        if (response.isSuccessful()) {
                            Session session = response.body();

                            MainApplication.saveSession(session);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            hideLoadingDialog();
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            Toast.makeText(LoginActivity.this, getString(R.string.generic_error), Toast.LENGTH_LONG).show();
                            hideLoadingDialog();
                        }

                    }

                    @Override
                    public void onFailure(Call<Session> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, getString(R.string.generic_error), Toast.LENGTH_LONG).show();
                        hideLoadingDialog();
                    }
                });
            }
        });

    }
}
