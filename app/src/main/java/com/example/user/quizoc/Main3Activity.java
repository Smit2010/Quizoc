package com.example.user.quizoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    int correct;
    String c;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i= getIntent();
        correct= i.getIntExtra("Result",correct);
        String c = Integer.toString(correct);
        result=(TextView) findViewById(R.id.resultd);
        result.setText(c);
    }
}
