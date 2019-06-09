package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.barbosa.gabriel.optform.MainApplication;
import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.adapters.OPTAdapter;
import com.barbosa.gabriel.optform.interfaces.OPTApi;
import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.Session;
import com.barbosa.gabriel.optform.models.Supervisor;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OPTList extends BaseActivity {
    private RecyclerView optRecyclerView;
    private OPTAdapter optAdapter;
    private Supervisor supervisor;
    private ArrayList<Operator> operators;
    private ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optlist);

        EditText optSearch = findViewById(R.id.search);
        optRecyclerView = findViewById(R.id.opt_list);

        optRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        showLoadingDialog(OPTList.this);

        if (getIntent().hasExtra("supervisor")
                && getIntent().hasExtra("operators")
                && getIntent().hasExtra("posts")) {

            supervisor = getIntent().getParcelableExtra("supervisor");
            operators = getIntent().getParcelableArrayListExtra("operators");
            posts = getIntent().getParcelableArrayListExtra("posts");

            OPTListTask optListTask = new OPTListTask(new OPTListTaskListener() {
                @Override
                public void optList(List<OPT> optList) {
                    optAdapter = new OPTAdapter(optList, new OPTAdapter.OPTClickListener() {
                        @Override
                        public void onOPTClickListener(OPT opt) {

                            Post post = null;
                            Operator operator = null;

                            for(Post forPost: posts){
                                if (opt.getPostoId().equals(forPost.getId())) {
                                    post = forPost;
                                    break;
                                }
                            }

                            for (Operator forOperator: operators){
                                if (opt.getOperadorId().equals(forOperator.getId())) {
                                    operator = forOperator;
                                    break;
                                }

                            }

                            Intent intent = new Intent(OPTList.this, OPTDetailsActivity.class);
                            intent.putExtra("opt", opt);
                            intent.putExtra("uet", supervisor.getUET());
                            intent.putExtra("post", post);
                            intent.putExtra("operator", operator);
                            startActivity(intent);

                        }
                    });
                    optRecyclerView.setAdapter(optAdapter);
                    hideLoadingDialog();
                }
            });

            optListTask.execute(supervisor);
        }

        optSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String query = s.toString();
                if (query.isEmpty())
                    optAdapter.resetFilter();
                else {
                    optAdapter.getFilter().filter(query);
                }
            }
        });

    }

    private interface OPTListTaskListener {
        void optList(List<OPT> optList);
    }

    private static class OPTListTask extends AsyncTask<Supervisor, Void, List<OPT>> {
        WeakReference<OPTListTaskListener> listenerWeakReference;

        OPTListTask(OPTListTaskListener taskListener) {
            listenerWeakReference = new WeakReference<>(taskListener);
        }

        @Override
        protected List<OPT> doInBackground(Supervisor... supervisors) {
            Session session = MainApplication.getSession();
            Retrofit retrofit = MainApplication.getRetrofit(session.getInstanceUrl());

            OPTApi optApi = retrofit.create(OPTApi.class);
            Call<List<OPT>> call = optApi.getOPTs(session.getAccessToken(), supervisors[0].getId());
            try {
                Response<List<OPT>> response = call.execute();
                if (response.isSuccessful()) {
                    return response.body();
                } else
                    return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(List<OPT> optList) {
            OPTListTaskListener taskListener = listenerWeakReference.get();
            if (taskListener != null)
                taskListener.optList(optList);
        }
    }
}
