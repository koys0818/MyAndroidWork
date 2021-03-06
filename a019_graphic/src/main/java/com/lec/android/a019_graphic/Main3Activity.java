package com.lec.android.a019_graphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(new myview3(this));  //linearLayout의 child로 들어감
        setContentView(ll);
    }
}

class myview3 extends View{

    Paint paint = new Paint();
    Path path = new Path();

    public myview3(Context context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE); //실선
        paint.setStrokeWidth(10f);  //
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);   //path 를 그리지 말고 위치이동만 함
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);   //path의 선 그리기
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}























