package com.lec.android.a012_vibrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

// 진동
// 1. 진동 권한을 획득해야한다. AndroidManifest.xml
// 2. Vibrator 객체를 얻어서 진동시킨다


public class MainActivity extends AppCompatActivity {

    Button btnvib1,btnvib2,btnvib3,btnvib4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnvib1 = findViewById(R.id.btnVib1);
        btnvib2 = findViewById(R.id.btnVib2);
        btnvib3 = findViewById(R.id.btnVib3);
        btnvib4 = findViewById(R.id.btnVib4);

        final Vibrator vibrator
                = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btnvib1.setText("5초 진동");
        btnvib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(5000);
            }
        });

        btnvib2.setText("지정한 패턴으로 진동");
        btnvib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long [] pattern = [100, 300, 100, 700, 300 ,2000];  //ms
                //                  대기 지동 대기 진동...
                // 홀수인덱스는 진동
                // 짝수인덱스는 대기
                vibrator.vibrate(pattern,   // 진동패턴
                        -1);    //반복
                //0 : 무한반복
                //양의 정수 : 진동패턴배열의 해당 인덱스부터 진동 무한 반복

            }
        });

        btnvib3.setText("무한 반복으로 진동");
        btnvib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(
                        new long [] { 100, 100 ,200 , 400 ,100 ,500 ,100 ,2000}
                        , 0
                );
            }
        });

        btnvib4.setText("진동 취소");
        btnvib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();  //진동취소
            }
        });

    }
}
