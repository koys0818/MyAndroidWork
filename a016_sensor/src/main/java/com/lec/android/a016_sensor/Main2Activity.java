package com.lec.android.a016_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    private TextView tv;
    private SensorManager sn;

    Sensor accelerometer;
    Sensor magnetometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.tvTitle);

        sn = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sn.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sn.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    //화면이 동작하기 직전에 센서 자원 획득
    @Override
    protected void onResume() {
        super.onResume();
        //센서 값이 변경되었을때마다 콜백 받기 위한 리스너 등록f    sensoreventlistener
        sn.registerListener((SensorEventListener)this,
                accelerometer,     //콜백 원하는 센서
                SensorManager.SENSOR_DELAY_UI   //지연시간
        );

        sn.registerListener((SensorEventListener)this,
                magnetometer,
        SensorManager.SENSOR_DELAY_UI);
    }

    //화면 빠져나가기 전에 센서 자원반납
    @Override
    protected void onPause() {
        super.onPause();
        sn.unregisterListener(this);
        //센서에 등록된 리스너 해제
    }

    float [] mGravity;
    float [] mGeomagnetic;


    //센서값이 변경될때마다 호출되는 콜백
    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            mGravity = event.values;    //센서값들은 float[]로 넘어옴

        if(mGravity != null && mGeomagnetic != null){
            float [] R = new float[9];
            float [] I = new float[9];

            boolean suc = SensorManager.getRotationMatrix(R,I,mGravity,mGeomagnetic);
            if(suc){
                float [] orient = new float[3]; //회전값
                SensorManager.getOrientation(R,orient);

                float azimuth = orient[0];  //z축 회전방향
                float pitch = orient[1];    //x축 회전
                float roll = orient[2]; //y축 회전

                String str = String.format("%10s:%10s:%10s\n%10.2f:%10.2f:%10.2f\n"
                ,"방위각", "피치", "롤"
                ,azimuth,pitch,roll);
                tv.setText(str);
                Log.d("myapp","str");
            }
        }


    }

    //센서의 정확도가 변결되었을때 호출되는 콜백
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        tv.setText("onAccuracyChanged");
        Log.d("myapp", "onAccuracyChanged");

    }
}
