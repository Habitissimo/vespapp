package com.habitissimo.vespapp.questions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.habitissimo.vespapp.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CuestionarioActivity extends AppCompatActivity {

    public static final String KEY_INDEX = "index";
    public static Sighting sighting;
    @Bind(R.id.container)
    ViewGroup container;
    private int index;

    public static void Lanch_Activity(Context cntx, int index) {
        Intent intent = new Intent(cntx, CuestionarioActivity.class);
        intent.putExtra(CuestionarioActivity.KEY_INDEX, index);
        CuestionarioActivity.sighting = createSigthing();
        cntx.startActivity(intent);
    }

    private static Sighting createSigthing() {
        ArrayList<Answer> ALans = new ArrayList<>();

        ALans.add(new Answer("1", "Titulo"));
        ALans.add(new Answer("2", "Titulo2"));
        int cuest = 1;
        Question question = new Question("21", ALans, "Jaume melocotonazo!", cuest);

        Sighting sighting = new Sighting();
        sighting.available_questions.add(question);
        sighting.available_questions.add(question);
        sighting.available_questions.add(question);
        return sighting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_activity);
        ButterKnife.bind(this);
        TextView questionTV = (TextView) findViewById(R.id.Pregunta);
//        Bundle extras = getIntent().getExtras();
//        index = extras.getInt(KEY_INDEX);

        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitulo));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        questionTV.setText(getQuestion().title);
        if (getQuestion().isCheckBox()) {
            createAnswersFromCheckBox();
        } else {
            createAnswersFromRadioButton();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        index = extras.getInt(KEY_INDEX);
    }

    private void createAnswersFromRadioButton() {
        RadioGroup radioGroup = new RadioGroup(this);
        container.addView(radioGroup);
        for (Answer answer : getQuestion().answers) {
            RadioButton button = new RadioButton(this);
            button.setText(answer.title);
            button.setTag(answer);
            radioGroup.addView(button);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                deleteLastAnswer(group);
                Answer answer = (Answer) rb.getTag();
                insertAnswerIntoSighting(answer);
                index++;
                if (nextStepExist()) {
                    moveToNextStep();
                }
            }
        });
    }

    private boolean nextStepExist() {
        return index < sighting.available_questions.size();
    }


    private void deleteLastAnswer(RadioGroup group) {
        RadioButton rb;
        for (int i = 0; i < group.getChildCount(); i++) {
            rb = (RadioButton) group.getChildAt(i);
            if (!rb.isSelected()) {
                deleteIfExists(rb);
            }
        }
    }

    private void deleteIfExists(RadioButton rb) {
        Answer answer = (Answer) rb.getTag();
        if (answerExists(answer)) {
            removeFromAnswer(answer.id);
        }
    }

    private void removeFromAnswer(String id) {
        sighting.answers.remove(id);
    }

    private boolean answerExists(Answer answer) {
        return sighting.answers.contains(answer.id);
    }


    private void insertAnswerIntoSighting(Answer answer) {
        sighting.addAnswer(answer);
    }

    private void createAnswersFromCheckBox() {
        Button button = new Button(this);
        button.setText("Siguiente");
        for (Answer answer : getQuestion().answers) {
            final CheckBox checkBox = new CheckBox(this);
            container.addView(checkBox);
            checkBox.setText(answer.title);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Answer answer = (Answer) checkBox.getTag();
                    if (isChecked) {
                        insertAnswerIntoSighting(answer);
                    } else {
                        deleteAnswerFromSighting(answer);
                    }
                }
            });
        }
        container.addView(button);
    }

    private void deleteAnswerFromSighting(Answer answer) {
        sighting.deleteAnswer(answer);
    }

    private Question getQuestion() {
        return sighting.available_questions.get(index);
    }

    private void moveToNextStep() {
        Lanch_Activity(this, index);
    }

}
