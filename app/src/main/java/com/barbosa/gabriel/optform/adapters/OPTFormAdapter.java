package com.barbosa.gabriel.optform.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.models.Questions;

public class OPTFormAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_OPT = 0;
    private static int TYPE_BUTTON = 1;
    private Questions questions;
    private FinishOPTCallback callback;

    public OPTFormAdapter(Questions questions, FinishOPTCallback finishOPTCallback) {
        this.questions = questions;
        this.callback = finishOPTCallback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_OPT)
            return new OPTViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.opt_form_item, viewGroup, false));
        else
            return new FinishOPT(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.opt_finish_item, viewGroup, false));
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 19) {
            return TYPE_OPT;
        } else
            return TYPE_BUTTON;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_OPT) {
            OPTViewHolder optViewHolder = (OPTViewHolder) holder;
            optViewHolder.setAdapterPosition(position);
            switch (position) {
                case 0:
                    optViewHolder.optQuestion.setText(questions.getQ1());
                    optViewHolder.optAnswer.setText(questions.getA1());
                    break;
                case 1:
                    optViewHolder.optQuestion.setText(questions.getQ2());
                    optViewHolder.optAnswer.setText(questions.getA2());
                    break;
                case 2:
                    optViewHolder.optQuestion.setText(questions.getQ3());
                    optViewHolder.optAnswer.setText(questions.getA3());
                    break;
                case 3:
                    optViewHolder.optQuestion.setText(questions.getQ4());
                    optViewHolder.optAnswer.setText(questions.getA4());
                    break;
                case 4:
                    optViewHolder.optQuestion.setText(questions.getQ5());
                    optViewHolder.optAnswer.setText(questions.getA5());
                    break;
                case 5:
                    optViewHolder.optQuestion.setText(questions.getQ6());
                    optViewHolder.optAnswer.setText(questions.getA6());
                    break;
                case 6:
                    optViewHolder.optQuestion.setText(questions.getQ7());
                    optViewHolder.optAnswer.setText(questions.getA7());
                    break;
                case 7:
                    optViewHolder.optQuestion.setText(questions.getQ8());
                    optViewHolder.optAnswer.setText(questions.getA8());
                    break;
                case 8:
                    optViewHolder.optQuestion.setText(questions.getQ9());
                    optViewHolder.optAnswer.setText(questions.getA9());
                    break;
                case 9:
                    optViewHolder.optQuestion.setText(questions.getQ10());
                    optViewHolder.optAnswer.setText(questions.getA10());
                    break;
                case 10:
                    optViewHolder.optQuestion.setText(questions.getQ11());
                    optViewHolder.optAnswer.setText(questions.getA11());
                    break;
                case 11:
                    optViewHolder.optQuestion.setText(questions.getQ12());
                    optViewHolder.optAnswer.setText(questions.getA12());
                    break;
                case 12:
                    optViewHolder.optQuestion.setText(questions.getQ13());
                    optViewHolder.optAnswer.setText(questions.getA13());
                    break;
                case 13:
                    optViewHolder.optQuestion.setText(questions.getQ14());
                    optViewHolder.optAnswer.setText(questions.getA14());
                    break;
                case 14:
                    optViewHolder.optQuestion.setText(questions.getQ15());
                    optViewHolder.optAnswer.setText(questions.getA15());
                    break;
                case 15:
                    optViewHolder.optQuestion.setText(questions.getQ16());
                    optViewHolder.optAnswer.setText(questions.getA16());
                    break;
                case 16:
                    optViewHolder.optQuestion.setText(questions.getQ17());
                    optViewHolder.optAnswer.setText(questions.getA17());
                    break;
                case 17:
                    optViewHolder.optQuestion.setText(questions.getQ18());
                    optViewHolder.optAnswer.setText(questions.getA18());
                    break;
                case 18:
                    optViewHolder.optQuestion.setText(questions.getQ19());
                    optViewHolder.optAnswer.setText(questions.getA19());
                    break;
            }
        } else if (getItemViewType(position) == TYPE_BUTTON) {
            FinishOPT finishOPT = (FinishOPT) holder;
            finishOPT.btnFinishOpt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.sendOPT(questions);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private void updateAnswer(int position, EditText optAnswer) {
        switch (position) {
            case 0:
                questions.setA1(optAnswer.getText().toString());
                break;
            case 1:
                questions.setA2(optAnswer.getText().toString());
                break;
            case 2:
                questions.setA3(optAnswer.getText().toString());
                break;
            case 3:
                questions.setA4(optAnswer.getText().toString());
                break;
            case 4:
                questions.setA5(optAnswer.getText().toString());
                break;
            case 5:
                questions.setA6(optAnswer.getText().toString());
                break;
            case 6:
                questions.setA7(optAnswer.getText().toString());
                break;
            case 7:
                questions.setA8(optAnswer.getText().toString());
                break;
            case 8:
                questions.setA9(optAnswer.getText().toString());
                break;
            case 9:
                questions.setA10(optAnswer.getText().toString());
                break;
            case 10:
                questions.setA11(optAnswer.getText().toString());
                break;
            case 11:
                questions.setA12(optAnswer.getText().toString());
                break;
            case 12:
                questions.setA13(optAnswer.getText().toString());
                break;
            case 13:
                questions.setA14(optAnswer.getText().toString());
                break;
            case 14:
                questions.setA15(optAnswer.getText().toString());
                break;
            case 15:
                questions.setA16(optAnswer.getText().toString());
                break;
            case 16:
                questions.setA17(optAnswer.getText().toString());
                break;
            case 17:
                questions.setA18(optAnswer.getText().toString());
                break;
            case 18:
                questions.setA19(optAnswer.getText().toString());
                break;
        }
    }

    public interface FinishOPTCallback {
        void sendOPT(Questions questions);
    }

    class OPTViewHolder extends RecyclerView.ViewHolder {
        TextView optQuestion;
        EditText optAnswer;
        int adapterPosition;

        OPTViewHolder(@NonNull View itemView) {
            super(itemView);
            optQuestion = itemView.findViewById(R.id.opt_question);
            optAnswer = itemView.findViewById(R.id.opt_answer);

            optAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    updateAnswer(adapterPosition, optAnswer);
                }
            });
        }

        private void setAdapterPosition(int position) {
            adapterPosition = position;
        }

    }

    class FinishOPT extends RecyclerView.ViewHolder {
        Button btnFinishOpt;

        FinishOPT(@NonNull View itemView) {
            super(itemView);
            btnFinishOpt = itemView.findViewById(R.id.btn_finish_opt);
        }
    }
}
