package com.lec.android.a006_widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    TextView tvResult;
    SeekBar seekbar;

    int value = 0;
    int add = 2;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = findViewById(R.id.tvResult);
        seekbar = findViewById(R.id.seekBar);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //값의 변화가 생겼을때
            //progress : 진행값 0 ~ max
            //fromUser : 사용자에 의한 진행값 변화인 경우 true
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvResult.setText("onprogress" + progress + "(" + fromUser + ")");
            }

            //tracking을 시작할때
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "트래킹시작", Toast.LENGTH_LONG).show();
            }

            //tracking이 끝날때
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "트래킹종료", Toast.LENGTH_LONG).show();
            }
        });

        //앱 시작시 thread... seekbar 증가 시키기

        new Thread(new Runnable() {
            @Override
            public void run() {

                int max = seekbar.getMax();

                while (true){
                    value = seekbar.getProgress() + add;

                    if(value > max || value < 0){
                        add = -add;
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
//                            seekbar.getProgress(value);
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();



    }//end create



}// end act
