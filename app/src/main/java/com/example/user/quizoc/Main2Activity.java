package com.example.user.quizoc;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.shapes.Shape;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
        Button[] o=new Button[4];
        TextView que;
        int count=1,count2=0,correct=0;
        String[] quest = new String[6];
        String[][] answer = new String[7][4];
        boolean hasAnswered=false;
        Boolean hasCompleted=false;
        //Shape shapee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
            que = (TextView) findViewById(R.id.QUES);
            o[1] = findViewById(R.id.Option1);
            o[2] = findViewById(R.id.Option2);
            o[3] = findViewById(R.id.Option3);
            quest[1] = getString(R.string.ques2);
            quest[2] = getString(R.string.ques3);
            quest[3] = getString(R.string.ques4);
            quest[4] = getString(R.string.ques5);
            quest[5] = getString(R.string.ques6);

            answer[1][1] = (getString(R.string.ans11));
            answer[1][2] = (getString(R.string.ans12));
            answer[1][3] = (getString(R.string.ans13));
            answer[2][1] = (getString(R.string.ans21));
            answer[2][2] = (getString(R.string.ans22));
            answer[2][3] = (getString(R.string.ans23));
            answer[3][1] = (getString(R.string.ans31));
            answer[3][2] = (getString(R.string.ans32));
            answer[3][3] = (getString(R.string.ans33));
            answer[4][1] = (getString(R.string.ans41));
            answer[4][2] = (getString(R.string.ans42));
            answer[4][3] = (getString(R.string.ans43));
            answer[5][1] = (getString(R.string.ans51));
            answer[5][2] = (getString(R.string.ans52));
            answer[5][3] = (getString(R.string.ans53));
            answer[6][1] = (getString(R.string.ans61));
            answer[6][2] = (getString(R.string.ans62));
            answer[6][3] = (getString(R.string.ans63));

            que.setText(R.string.ques1);
            o[1].setText(answer[1][1]);
            o[2].setText(answer[1][2]);
            o[3].setText(answer[1][3]);
            o[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hasAnswered) {
                        o[1].setEnabled(false);
                        o[2].setEnabled(false);
                        o[3].setEnabled(false);
                        hasAnswered = true;
                        count++;
                        checkAnswer(1);
                        if(count<7) {
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    nxtOption1();
                                    nxtOption2();
                                    nxtOption3();
                                    nxtQuest();
                                }
                            }, 2000);
                        }
                        else{
                            hasCompleted=true;
                            Toast.makeText(Main2Activity.this, "Thanks for answering", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(getApplicationContext(),Main3Activity.class);
                            i.putExtra("Result",correct);
                            //i.putExtra("hasCompleted",hasCompleted);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            });

            o[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!hasAnswered) {
                        o[1].setEnabled(false);
                        o[2].setEnabled(false);
                        o[3].setEnabled(false);
                        hasAnswered = true;
                        count++;
                        checkAnswer(2);
                        if(count<7) {
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    nxtOption1();
                                    nxtOption2();
                                    nxtOption3();
                                    nxtQuest();
                                }
                            }, 2000);
                        }
                        else{
                            hasCompleted=true;
                            Toast.makeText(Main2Activity.this, "Thanks for answering", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(getApplicationContext(),Main3Activity.class);
                            i.putExtra("Result",correct);
                            //i.putExtra("hasCompleted",hasCompleted);
                            startActivity(i);
                            finish();
                            }

                    }

                }
            });

            o[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hasAnswered) {
                        o[1].setEnabled(false);
                        o[2].setEnabled(false);
                        o[3].setEnabled(false);
                        hasAnswered = true;
                        count++;
                        checkAnswer(3);
                        if(count<7) {
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    nxtOption1();
                                    nxtOption2();
                                    nxtOption3();
                                    nxtQuest();
                                }
                            }, 2000);
                        }
                        else{
                            hasCompleted=true;
                            Toast.makeText(Main2Activity.this, "Thanks for answering", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(getApplicationContext(),Main3Activity.class);
                            i.putExtra("Result",correct);
                            //i.putExtra("hasCompleted",hasCompleted);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            });

    }

    private void nxtOption1() {
        o[1].setText(answer[count][1]);
        hasAnswered = false;
        o[1].setBackground(getDrawable(R.drawable.borders));
        o[1].setEnabled(true);

    }

    private void nxtOption2() {
        o[2].setText(answer[count][2]);
        // hasAnswered=false;
        o[2].setBackground(getDrawable(R.drawable.borders));
        o[2].setEnabled(true);
    }

    private void nxtOption3() {
        o[3].setText(answer[count][3]);
        //hasAnswered=false;
        o[3].setBackground(getDrawable(R.drawable.borders));
        o[3].setEnabled(true);
    }

    private void nxtQuest() {



            que.setText(quest[count - 1]);

    }

    private void checkAnswer(int a) {
        int ans;
        switch (count - 1) {
            case 1:
                ans = 1;
                break;
            case 2:
                ans = 3;
                break;
            case 3:
                ans = 2;
                break;
            case 4:
                ans = 3;
                break;
            case 5:
                ans = 3;
                break;
            case 6:
                ans = 1;
                break;
            default:
                ans = -1;
                break;
        }
        if (a == ans) {
            o[a].setBackground(getDrawable(R.drawable.borders_green));
            correct++;
        } else {
            o[a].setBackground(getDrawable(R.drawable.borders_red));
            final int temp = ans;
           /* ObjectAnimator anim = ObjectAnimator.ofInt(o[ans] , "backgroundColor" , R.drawable.borders, R.drawable.borders_green, R.drawable.borders);
            anim.setDuration(1000);
            anim.setEvaluator(new ArgbEvaluator());
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            anim.start();*/
            /*for (int i = 0; i < 8; i++) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (count2 % 2 == 1) {
                            o[temp].setBackground(getDrawable(R.drawable.borders));
                            count2++;
                        } else {
                            o[temp].setBackground(getDrawable(R.drawable.borders_green));
                            count2++;
                        }
                    }
                }, 250 * i);*/
            }

        }
    }
