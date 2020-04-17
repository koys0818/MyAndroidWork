package com.lec.android.a007_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_two);


        Button btnfin = findViewById(R.id.btnFinish);

        btnfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   //엑티비티 종료 명령어
            }
        });

        //넘겨받은 intent 객체를 받는다
        final Intent intent = getIntent();

        int a = intent.getIntExtra("num", 0);    // num이라는 name로 넘어온 값
                                                            //만약 num이라는 name이 인텐트에 없었으면
                                                            // 디폴트값(두번째 매개변수) 룰 리턴
        int b = intent.getIntExtra("num2" , 0);
        int c = intent.getIntExtra("num3" , 999); //num3라는 이름은 없었다
        long l = intent.getLongExtra("long", 0);

        String msg = intent.getStringExtra("msg");  //리턴값이 object인 경우엔 디폴트값 설정없다
                                                            // name이 없으면 NULL리턴

        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("인텐트 받은 값 : " + a + " : " + b + " : " + c + " : " + l + " : " + msg);

        //Person 데이터 받기
        Person p = (Person)intent.getSerializableExtra("Person");   //person 으로 형변환

        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText("Person 받은 값 : " + p.getName() + " : " + p.getAge());


        //첫번째 엑티비티로 인텐트를 날림ㄴ
        Button btntoMain = findViewById(R.id.btnToMain);
        btntoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });





    }


}
