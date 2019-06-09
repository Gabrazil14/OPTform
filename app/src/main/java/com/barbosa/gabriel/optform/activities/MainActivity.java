package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.interfaces.OPTApi;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.Questions;
import com.barbosa.gabriel.optform.models.Session;
import com.barbosa.gabriel.optform.models.Supervisor;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {
    private Session session;
    private Supervisor supervisor;
    private ArrayList<Post> posts;
    private ArrayList<Operator> operators;
    private Questions questions;
    private TextView welcomeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = MainApplication.getSession();
        if (!session.isValid()) {
            redirectToLogin();
        } else {
            welcomeLabel = findViewById(R.id.welcome_label);
            Button newOPT = findViewById(R.id.btn_new_opt);
            newOPT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OPTActivity.class);
                    intent.putExtra("supervisor", supervisor);
                    intent.putParcelableArrayListExtra("posts", posts);
                    intent.putParcelableArrayListExtra("operators", operators);
                    intent.putExtra("questions", questions);
                    startActivity(intent);
                }
            });
            showLoadingDialog(this);
            LoadRequiredData loadRequiredData = new LoadRequiredData(MainActivity.this);
            loadRequiredData.execute();
        }
    }

    private void redirectToLogin() {
        session.invalidate();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    private void setWelcomeLabel(final String name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                welcomeLabel.setText(getString(R.string.welcome, name));
            }
        });
    }

    private void showErrorToast() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, getString(R.string.generic_error), Toast.LENGTH_LONG).show();
                hideLoadingDialog();
            }
        });
    }

    static class LoadRequiredData extends AsyncTask<Void, Void, Void> {
        WeakReference<MainActivity> activityWeakReference;

        LoadRequiredData(MainActivity mainActivity) {
            activityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        protected Void doInBackground(Void[] voids) {
            MainActivity mainActivity = activityWeakReference.get();
            if (mainActivity != null) {
                Supervisor supervisor;
                Session session = mainActivity.session;
                ArrayList<Post> posts;
                ArrayList<Operator> operators;
                Questions questions;

                Retrofit retrofit = MainApplication.getRetrofit(session.getInstanceUrl());
                OPTApi optApi = retrofit.create(OPTApi.class);
                Call<Supervisor> supervisorCall = optApi.getSupervisor(session.getAccessToken());
                try {
                    Response<Supervisor> supervisorResponse = supervisorCall.execute();
                    if (supervisorResponse.isSuccessful()) {
                        supervisor = supervisorResponse.body();
                        mainActivity.setWelcomeLabel(supervisor.getName());

                        Call<ArrayList<Post>> postCall = optApi.getPost(session.getAccessToken(), supervisor.getUET().getId());
                        Response<ArrayList<Post>> postResponse = postCall.execute();

                        if (postResponse.isSuccessful()) {
                            posts = postResponse.body();

                            Call<ArrayList<Operator>> operatorsCall = optApi.getOperators(session.getAccessToken(), supervisor.getId());
                            Response<ArrayList<Operator>> operatorsResponse = operatorsCall.execute();
                            if (operatorsResponse.isSuccessful()) {
                                operators = operatorsResponse.body();

                                Call<Questions> questionsCall = optApi.getQuestions(session.getAccessToken());
                                Response<Questions> questionsResponse = questionsCall.execute();

                                if (questionsResponse.isSuccessful()){
                                    questions = questionsResponse.body();
                                    mainActivity.supervisor = supervisor;
                                    mainActivity.posts = posts;
                                    mainActivity.operators = operators;
                                    mainActivity.questions = questions;
                                    mainActivity.hideLoadingDialog();
                                }

                            } else {
                                mainActivity.showErrorToast();
                            }

                        } else {
                            mainActivity.showErrorToast();
                        }

                    } else {
                        if (supervisorResponse.code() == 401 || supervisorResponse.code() == 403) {
                            mainActivity.redirectToLogin();
                        } else {
                            mainActivity.showErrorToast();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    mainActivity.showErrorToast();
                }
            }
            return null;
        }
    }
}
