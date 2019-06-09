package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.adapters.OPTFormAdapter;
import com.barbosa.gabriel.optform.interfaces.OPTApi;
import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Questions;
import com.barbosa.gabriel.optform.models.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OPTFormActivity extends BaseActivity {
    private OPT opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optform);

        if (getIntent().hasExtra("opt")) {
            opt = getIntent().getParcelableExtra("opt");
            Questions questions = new Questions(opt.getQ10(),
                    opt.getQ11(),
                    opt.getQ12(),
                    opt.getQ13(),
                    opt.getQ14(),
                    opt.getQ15(),
                    opt.getQ16(),
                    opt.getQ17(),
                    opt.getQ18(),
                    opt.getQ19(),
                    opt.getQ1(),
                    opt.getQ2(),
                    opt.getQ3(),
                    opt.getQ4(),
                    opt.getQ5(),
                    opt.getQ6(),
                    opt.getQ7(),
                    opt.getQ8(),
                    opt.getQ9(),
                    opt.getA10(),
                    opt.getA11(),
                    opt.getA12(),
                    opt.getA13(),
                    opt.getA14(),
                    opt.getA15(),
                    opt.getA16(),
                    opt.getA17(),
                    opt.getA18(),
                    opt.getA19(),
                    opt.getA1(),
                    opt.getA2(),
                    opt.getA3(),
                    opt.getA4(),
                    opt.getA5(),
                    opt.getA6(),
                    opt.getA7(),
                    opt.getA8(),
                    opt.getA9());
            OPTFormAdapter optFormAdapter = new OPTFormAdapter(questions, new OPTFormAdapter.FinishOPTCallback() {
                @Override
                public void sendOPT(Questions questions) {
                    showLoadingDialog(OPTFormActivity.this);
                    opt.setA1(questions.getA1());
                    opt.setA2(questions.getA1());
                    opt.setA3(questions.getA1());
                    opt.setA4(questions.getA1());
                    opt.setA5(questions.getA1());
                    opt.setA6(questions.getA1());
                    opt.setA7(questions.getA1());
                    opt.setA8(questions.getA1());
                    opt.setA9(questions.getA1());
                    opt.setA10(questions.getA1());
                    opt.setA11(questions.getA1());
                    opt.setA12(questions.getA1());
                    opt.setA13(questions.getA1());
                    opt.setA14(questions.getA1());
                    opt.setA15(questions.getA1());
                    opt.setA16(questions.getA1());
                    opt.setA17(questions.getA1());
                    opt.setA18(questions.getA1());
                    opt.setA19(questions.getA1());

                    Session session = MainApplication.getSession();

                    Retrofit retrofit = MainApplication.getRetrofit(session.getInstanceUrl());
                    OPTApi optApi = retrofit.create(OPTApi.class);
                    Call<OPT> optCall = optApi.sendOPT(session.getAccessToken(), opt);
                    optCall.enqueue(new Callback<OPT>() {
                        @Override
                        public void onResponse(Call<OPT> call, Response<OPT> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(OPTFormActivity.this, getString(R.string.opt_success), Toast.LENGTH_LONG).show();
                                hideLoadingDialog();
                                Intent intent = new Intent(OPTFormActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                Toast.makeText(OPTFormActivity.this, getString(R.string.generic_error), Toast.LENGTH_LONG).show();
                                hideLoadingDialog();
                            }

                        }

                        @Override
                        public void onFailure(Call<OPT> call, Throwable t) {
                            Toast.makeText(OPTFormActivity.this, getString(R.string.generic_error), Toast.LENGTH_LONG).show();
                            hideLoadingDialog();
                        }
                    });
                }
            });
            RecyclerView optRecyclerView = findViewById(R.id.recycler_view_opt);
            optRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            optRecyclerView.setAdapter(optFormAdapter);
        }

    }
}
