package com.lec.android.a019_graphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        setContentView(new myview2(this));
    }
}

class myview2 extends View{

    int x = 100; int y = 100;

    public myview2(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(50);

        paint.setColor(Color.BLUE);
        canvas.drawRect(x - 100, y -100,  x + 200,  y + 200, paint);

        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("글씨", 200, 200 ,paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                x=(int)event.getX();
                y=(int)event.getY();
                invalidate();   //화면을 다시 그려주기 ondrow를 다시 호출한다
        }
        return true;
    }
}