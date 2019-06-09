package com.barbosa.gabriel.optform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.adapters.OperatorAdapter;
import com.barbosa.gabriel.optform.adapters.PostAdapter;
import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.Questions;
import com.barbosa.gabriel.optform.models.Supervisor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OPTActivity extends BaseActivity {
    private Supervisor supervisor;
    private Post post;
    private Operator operator;
    private Questions questions;

    private OPT opt;

    private OperatorAdapter operatorAdapter;
    private PostAdapter postAdapter;

    private EditText filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);

        TextView supervisorName = findViewById(R.id.supervisor_name);
        TextView date = findViewById(R.id.opt_date);
        TextView shift = findViewById(R.id.opt_shift);
        TextView uet = findViewById(R.id.opt_uet);
        Spinner operatorsSpinner = findViewById(R.id.spinner_opt_op);
        Spinner postSpinner = findViewById(R.id.spinner_opt_post);

        Button startButton = findViewById(R.id.btn_start);
        filter = findViewById(R.id.opt_filter);

        Date todayDate = Calendar.getInstance().getTime();
        String formattedTodayDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(todayDate);
        date.setText(getString(R.string.opt_date, formattedTodayDate));

        if (getIntent().hasExtra("supervisor")) {
            supervisor = getIntent().getParcelableExtra("supervisor");
            supervisorName.setText(getString(R.string.opt_supervisor_name, supervisor.getName()));
            shift.setText(getString(R.string.opt_shift, supervisor.getTurno()));
            uet.setText(getString(R.string.opt_uet, supervisor.getUET().getName()));
        }

        if (getIntent().hasExtra("posts")) {
            ArrayList<Post> posts = getIntent().getParcelableArrayListExtra("posts");
            postAdapter = new PostAdapter(OPTActivity.this, android.R.layout.simple_spinner_dropdown_item, posts);
            postSpinner.setAdapter(postAdapter);
            postSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    post = postAdapter.getItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        if (getIntent().hasExtra("operators")) {
            ArrayList<Operator> operators = getIntent().getParcelableArrayListExtra("operators");
            operatorAdapter = new OperatorAdapter(OPTActivity.this, android.R.layout.simple_spinner_dropdown_item, operators);
            operatorsSpinner.setAdapter(operatorAdapter);
            operatorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    operator = operatorAdapter.getItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        if (getIntent().hasExtra("questions")) {
            questions = getIntent().getParcelableExtra("questions");
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt = new OPT(post.getId(),
                        filter.getText().toString(),
                        operator.getId(),
                        post.getId(),
                        questions.getId(),
                        questions.getQ10(),
                        questions.getQ11(),
                        questions.getQ12(),
                        questions.getQ13(),
                        questions.getQ14(),
                        questions.getQ15(),
                        questions.getQ16(),
                        questions.getQ17(),
                        questions.getQ18(),
                        questions.getQ19(),
                        questions.getQ1(),
                        questions.getQ2(),
                        questions.getQ3(),
                        questions.getQ4(),
                        questions.getQ5(),
                        questions.getQ6(),
                        questions.getQ7(),
                        questions.getQ8(),
                        questions.getQ9(),
                        supervisor.getId(),
                        supervisor.getUET().getId());

                Intent intent = new Intent(OPTActivity.this, OPTFormActivity.class);
                intent.putExtra("opt", opt);
                startActivity(intent);
            }
        });
    }
}
