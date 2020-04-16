package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    RadioGroup rgroup;
    Button btnResult;
    TextView tvREsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //체크박스와 달리
        //radiobutton은 각각 선언하는게 아니라 그룹으로 선언하여 사용

        rgroup = findViewById(R.id.rg);
        btnResult = findViewById(R.id.btnResult);
        tvREsult = findViewById(R.id.tvResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택된 라디오 버튼의 id값 가져오기
                int id = rgroup.getCheckedRadioButtonId();

                //위 id값을 통해 라디오 버튼 객체 가져오기
                RadioButton rb = findViewById(id);

                tvREsult.setText(rb.getText());

            }
        });
        
        //라디오 버튼을 선택했을때도 위와 같은 동작하게 하기
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // checkedid 선택된 라디오버튼의 id
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                tvREsult.setText("결과 : " + rb.getText());
            }
        });




    }//end create
}// end Activity
