package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView calresult;
    EditText et;
    String first = "";
    String second = "";
    String i = "";
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnr = findViewById(R.id.btnres);
        Button btnplus = findViewById(R.id.btnplu);
        Button btnmin = findViewById(R.id.btnmin);
        Button btnmul = findViewById(R.id.btnmul);
        Button btndiv = findViewById(R.id.btndiv);
        Button btnclear = findViewById(R.id.btnclear);

        String cal;


        calresult = findViewById(R.id.calresult);
        et = findViewById(R.id.et);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "1 클릭");
                a = 1;
                et.getText().append("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "2 클릭");
                a = 2;
                et.getText().append("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "3 클릭");
                a = 3;
                et.getText().append("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "4 클릭");
                a = 4;
                et.getText().append("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "5 클릭");
                a = 5;
                et.getText().append("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "6 클릭");
                a = 6;
                et.getText().append("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "7 클릭");
                a = 7;
                et.getText().append("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "8 클릭");
                a = 8;
                et.getText().append("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "9 클릭");
                a = 9;
                et.getText().append("9");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "+클릭");


                if(i != ""){
                    if(calresult.getText().toString() != "0"){
                        first = calresult.getText().toString();
                    }

                    second = et.getText().toString();
                    Integer x = 0;
                    x = Integer.parseInt(first) + Integer.parseInt(second);



                    calresult.setText(x.toString());
                }
                else{
                    first = et.getText().toString();
                }

                i = "+";
                et.setText("");

            }
        });


        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "X클릭");

                if(i != ""){
                    if(calresult.getText().toString() != "0"){
                        first = calresult.getText().toString();
                    }

                    second = et.getText().toString();
                    Integer x = 0;
                    x = Integer.parseInt(first) * Integer.parseInt(second);



                    calresult.setText(x.toString());
                }
                else{
                    first = et.getText().toString();
                }

                i = "*";
                et.setText("");
            }
        });


        btnmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "-클릭");

                if(i != ""){
                    if(calresult.getText().toString() != "0"){
                        first = calresult.getText().toString();
                    }

                    second = et.getText().toString();
                    Integer x = 0;
                    x = Integer.parseInt(first) - (Integer.parseInt(second));



                    calresult.setText(x.toString());
                }
                else{
                    first = et.getText().toString();
                }

                i = " - ";
                et.setText("");
            }
        });


        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "/클릭");

                if(i != ""){
                    if(calresult.getText().toString() != "0"){
                        first = calresult.getText().toString();
                    }

                    second = et.getText().toString();
                    Integer x = 0;
                    x = Integer.parseInt(first) / Integer.parseInt(second);



                    calresult.setText(x.toString());
                }
                else{
                    first = et.getText().toString();
                }

                i = "/";
                et.setText("");
            }
        });

        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                et.setText(Integer.parseInt(et.getText().append(calresult.getText()).toString()));
//                et.setText(Integer.parseInt(()));
                second = et.getText().toString();
                Integer x = 0;

                switch (i){
                    case "+": x = Integer.parseInt(first) + Integer.parseInt(second); break;
                    case " - ": x = Integer.parseInt(first) - Integer.parseInt(second); break;
                    case "*": x = Integer.parseInt(first) * Integer.parseInt(second); break;
                    case "/": x = Integer.parseInt(first) / Integer.parseInt(second); break;

                }
                et.setText(x.toString());
                calresult.setText(x.toString());
                i = "";

            }




        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                calresult.setText("0");
                i = "";
                first = "";
                second = "";
            }
        });







    }
}