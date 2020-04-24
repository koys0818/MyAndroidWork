package com.lec.android.a018_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    TextView tvresult;

    //3개까지의 멀티터치를 다루기 위한 배열
    int id [] = new int[3];
    int x[] = new int[3];
    int y[] = new int[3];
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvresult = findViewById(R.id.tvResult);



    }//end create

    // 액티비티에서 발생한 터치 이벤트 처리
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointcnt = event.getPointerCount();//현재 터치 발생한 포인트 개수를 얻어온다.
        if(pointcnt > 3) pointcnt = 3;  //4개이상의 포인트 터치했더라도 3개까지만 처리

        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:   //한개 포인트에 대한 DOWN이 발생했을때
                id[0] =event.getPointerId(0);  //터지한 순간에 부여되는 포인트 고유번호 매개변수없을떈 0
                x[0] = (int)(event.getX());
                y[0] = (int)(event.getY());
                result = "싱글터치 :\n";
                result += "(" + x[0] + ", " + y[0] + ")";
                break;
            case MotionEvent.ACTION_POINTER_DOWN:   //두개 싱상의 포인트에 대한 DOWN이 발생했을떄
                result = "멀티터치 : \n";
                for(int i = 0 ; i < pointcnt; i++){
                    id[i] =event.getPointerId(i);
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    result += "id[" + id[i] + "] (" + x[0] + ", " + y[0] + ")";
                }
                break;

            case MotionEvent.ACTION_MOVE:
                result = "멀티터치무브 : \n";
                for(int i = 0 ; i < pointcnt; i++){
                    id[i] =event.getPointerId(i);
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    result += "id[" + id[i] + "] (" + x[0] + ", " + y[0] + ")";
                }
                break;
            case MotionEvent.ACTION_UP:
                result = "";
                break;
        }

        tvresult.setText(result);

        return super.onTouchEvent(event);
    }
}//end activity
