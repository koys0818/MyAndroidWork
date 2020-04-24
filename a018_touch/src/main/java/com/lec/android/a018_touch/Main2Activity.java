package com.lec.android.a018_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {

    ImageView ivrobot;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivrobot = findViewById(R.id.ivRobot);
        ll = findViewById(R.id.linearLayout1);

        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:   //버튼이 눌렸을때
                    case MotionEvent.ACTION_MOVE:   // 버튼을 누른 상태에서 움직이고 있을떼 (드래그상태)
                    case MotionEvent.ACTION_UP:
                        //이미지뷰의 위치 옮기기
                    ivrobot.setX(event.getX());
                    ivrobot.setY(event.getY());
                }

                return true;
            }
        });
    }
}
