package com.example.user.quizoc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;

  //  SharedPreferences pref /*=getSharedPreferences("MyPref", 0);
   // SharedPreferences.Editor editor = pref.edit();*/
    Boolean hasCompleted =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.button);
        //Intent i =getIntent();
        //hasCompleted=i.getBooleanExtra("hasCompleted",hasCompleted);
        if(!hasCompleted)
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                finish();
            }
        });
        else{
            start.setText("View Results");
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                    finish();
                }
            });
        }

    }

}
