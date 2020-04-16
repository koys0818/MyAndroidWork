package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String first = "";
    String second = "";
    int a = 0;
    EditText op1;
    EditText op2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnplus = findViewById(R.id.btnPlus);
        Button btmin = findViewById(R.id.btnMinus);
        Button btnmul = findViewById(R.id.btnMul);
        Button btndiv = findViewById(R.id.btnDiv);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = Integer.parseInt(op1.toString()) + Integer.parseInt(op2.toString());
            }
        });



    }
}
