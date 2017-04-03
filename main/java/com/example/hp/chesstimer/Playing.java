package com.example.hp.chesstimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Playing extends AppCompatActivity {

    private TextView tv,tv1;
    private Button start,stop;
    private ToggleButton pause;

    private boolean isPaused = false;
    private boolean isCanceled = false;
    private long remainingTime = 0;
    private long userTime = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_playing);

        final String str = getIntent().getStringExtra("clock");
        final String p1 = getIntent().getStringExtra("p1");
        final String p2 = getIntent().getStringExtra("p2");
            userTime = Long.parseLong(str);
            tv = (TextView) findViewById(R.id.tv1);
            tv1 = (TextView) findViewById(R.id.player);
            start = (Button) findViewById(R.id.bt2);
            pause = (ToggleButton) findViewById(R.id.bt1);
            stop = (Button) findViewById(R.id.bt3);

            tv.setText(str);
            tv1.setText(p1);
            stop.setEnabled(false);
            pause.setEnabled(false);

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start.setEnabled(false);
                    stop.setEnabled(true);
                    pause.setEnabled(true);

                    isPaused = false;
                    isCanceled = false;

                    long millisInFuture = userTime*1000;
                    long countDownInterval = 1000;

                    new CountDownTimer(millisInFuture, countDownInterval) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if (isPaused || isCanceled)
                                cancel();
                            else {
                                tv.setText(""+(millisUntilFinished / 1000));
                                remainingTime = millisUntilFinished;
                            }
                        }

                        @Override
                        public void onFinish() {
                            tv.setText("is the LOSER");
                            tv.setTextSize(50);
                            start.setEnabled(false);
                            stop.setEnabled(false);
                            pause.setEnabled(false);
                        }
                    }.start();
                }
            });



            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pause.isChecked()) {
                        isPaused = true;
                    } else {
                        isPaused = false;

                                long millisInFuture = remainingTime;
                                long countDownInterval = 1000;

                                new CountDownTimer(millisInFuture, countDownInterval) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        if (isPaused || isCanceled)
                                            cancel();
                                        else {
                                            tv.setText("" + millisUntilFinished / 1000);
                                            remainingTime = millisUntilFinished;
                                        }
                                    }
                                    @Override
                                    public void onFinish() {
                                        tv.setText("is the LOSER");
                                        tv.setTextSize(50);
                                        start.setEnabled(false);
                                        stop.setEnabled(false);
                                        pause.setEnabled(false);
                                    }
                                }.start();
                            }
                    }
            });
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isCanceled = true;
                    tv.setText(str);
                    start.setEnabled(true);
                    pause.setEnabled(false);
                    stop.setEnabled(false);
                    if(tv1.getText().toString().equals(p1))
                        tv1.setText(p2);
                    else
                        tv1.setText(p1);
                }


            });

    }
}