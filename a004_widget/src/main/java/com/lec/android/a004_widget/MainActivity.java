package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName,etPassword,etNumber,etEmail;
    TextView tvName,tvPassword,tvNumber,tvEmail;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etNumber = findViewById(R.id.etNumber);
        etEmail = findViewById(R.id.etEmail);

        tvName = findViewById(R.id.tvName);
        tvPassword = findViewById(R.id.tvPassword);
        tvNumber = findViewById(R.id.tvNumber);
        tvEmail = findViewById(R.id.tvEmail);

        tvResult = findViewById(R.id.tvResult);

        //포커스 변화
        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            //hasfocus 는 포커스를 받으면 true 잃으면 false
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    ((EditText) v).setBackgroundColor(Color.YELLOW);
                } else{
                        //배경 투명색
                    ((EditText)v).setBackgroundColor(Color.parseColor("#00000000"));
                    }
            }
        });

        //키보드가 눌릴때
        //자판키보드에만 적용
        etPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                tvResult.setText( ((EditText)v).getText().toString() );
                return false;
            }
        });

        //값의 변화
        etEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                tvResult.setText("입력완료 : " + actionId);
                return false;
            }
        });

    }
}
