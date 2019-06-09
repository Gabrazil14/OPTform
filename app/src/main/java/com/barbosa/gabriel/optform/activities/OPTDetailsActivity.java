package com.barbosa.gabriel.optform.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.UET;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class OPTDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optdetails);

        OPT opt;
        Post post;
        Operator operator;
        UET uet;


        if (getIntent().hasExtra("opt")
                && getIntent().hasExtra("post")
                && getIntent().hasExtra("operator")
                && getIntent().hasExtra("uet")) {

            opt = getIntent().getParcelableExtra("opt");
            post = getIntent().getParcelableExtra("post");
            operator = getIntent().getParcelableExtra("operator");
            uet = getIntent().getParcelableExtra("uet");



            TextView date = findViewById(R.id.opt_date);

            String formattedTodayDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(opt.getCreatedDate());
            date.setText(getString(R.string.opt_date, formattedTodayDate));

            TextView uetName = findViewById(R.id.opt_uet);
            uetName.setText(getString(R.string.opt_uet, uet.getName()));

            TextView filter = findViewById(R.id.opt_filter);
            filter.setText(getString(R.string.opt_filter_detail, opt.getFiltroId()));

            TextView operatorName = findViewById(R.id.label_operator);
            operatorName.setText(getString(R.string.opt_op_detail, operator.getName()));

            TextView postName = findViewById(R.id.opt_post);
            postName.setText(getString(R.string.opt_post_detail, post.getName()));

//            TextView shift = findViewById(R.id.opt_shift);
//            shift.setText(opt.);

            TextView q1 = findViewById(R.id.question1);
            q1.setText(opt.getQ1());

            TextView q2 = findViewById(R.id.question2);
            q2.setText(opt.getQ2());

            TextView q3 = findViewById(R.id.question3);
            q3.setText(opt.getQ3());

            TextView q4 = findViewById(R.id.question4);
            q4.setText(opt.getQ4());

            TextView q5 = findViewById(R.id.question5);
            q5.setText(opt.getQ5());

            TextView q6 = findViewById(R.id.question6);
            q6.setText(opt.getQ6());

            TextView q7 = findViewById(R.id.question7);
            q7.setText(opt.getQ7());

            TextView q8 = findViewById(R.id.question8);
            q8.setText(opt.getQ8());

            TextView q9 = findViewById(R.id.question9);
            q9.setText(opt.getQ9());

            TextView q10 = findViewById(R.id.question10);
            q10.setText(opt.getQ10());

            TextView q11 = findViewById(R.id.question11);
            q11.setText(opt.getQ11());

            TextView q12 = findViewById(R.id.question12);
            q12.setText(opt.getQ12());

            TextView q13 = findViewById(R.id.question13);
            q13.setText(opt.getQ13());

            TextView q14 = findViewById(R.id.question14);
            q14.setText(opt.getQ14());

            TextView q15 = findViewById(R.id.question15);
            q15.setText(opt.getQ15());

            TextView q16 = findViewById(R.id.question16);
            q16.setText(opt.getQ16());

            TextView q17 = findViewById(R.id.question17);
            q17.setText(opt.getQ17());

            TextView q18 = findViewById(R.id.question18);
            q18.setText(opt.getQ18());

            TextView q19 = findViewById(R.id.question19);
            q19.setText(opt.getQ19());

            TextView a1 = findViewById(R.id.answer1);
            a1.setText(opt.getA1());

            TextView a2 = findViewById(R.id.answer2);
            a2.setText(opt.getA2());

            TextView a3 = findViewById(R.id.answer3);
            a3.setText(opt.getA3());

            TextView a4 = findViewById(R.id.answer4);
            a4.setText(opt.getA4());

            TextView a5 = findViewById(R.id.answer5);
            a5.setText(opt.getA5());

            TextView a6 = findViewById(R.id.answer6);
            a6.setText(opt.getA6());

            TextView a7 = findViewById(R.id.answer7);
            a7.setText(opt.getA7());

            TextView a8 = findViewById(R.id.answer8);
            a8.setText(opt.getA8());

            TextView a9 = findViewById(R.id.answer9);
            a9.setText(opt.getA9());

            TextView a10 = findViewById(R.id.answer10);
            a10.setText(opt.getA10());

            TextView a11 = findViewById(R.id.answer11);
            a11.setText(opt.getA11());

            TextView a12 = findViewById(R.id.answer12);
            a12.setText(opt.getA12());

            TextView a13 = findViewById(R.id.answer13);
            a13.setText(opt.getA13());

            TextView a14 = findViewById(R.id.answer14);
            a14.setText(opt.getA14());

            TextView a15 = findViewById(R.id.answer15);
            a15.setText(opt.getA15());

            TextView a16 = findViewById(R.id.answer16);
            a16.setText(opt.getA16());

            TextView a17 = findViewById(R.id.answer17);
            a17.setText(opt.getA17());

            TextView a18 = findViewById(R.id.answer18);
            a18.setText(opt.getA18());

            TextView a19 = findViewById(R.id.answer19);
            a19.setText(opt.getA19());
        }
    }
}
