package com.lec.android.a014_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dlg1;
    Dialog dlg2;
    ImageView iv;
    Button btndlg;
    TextView tvresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dialog 클래스로 다이얼로그 객체 생성및 세팅
        dlg1 = new Dialog(this);    //다이얼로그 객체 생성
        dlg1.setContentView(R.layout.dialog_layout11);  //다이얼로그 화면 등록

        //Dialog 안의 view 객체들 얻어오기
        iv = dlg1.findViewById(R.id.ivDlgBanner);
        btndlg = dlg1.findViewById(R.id.btnDlgEvent);

        btndlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.face16);
                Toast.makeText(getApplicationContext(),"다이얼로그 버튼을 눌렀어요",Toast.LENGTH_LONG).show();
            }
        });

        //Activity 에 Dialog 등록하기
        dlg1.setOwnerActivity(MainActivity.this);
        dlg1.setCanceledOnTouchOutside(true);   //다이얼로그 바깥 영역 클릭시 (혹은 back 버튼 클릭시)
                                //종료할것인지 여부 true 종료됨 false 안됨

        dlg2 = new Dialog(this);
        dlg2.setContentView(R.layout.dialog_layout12);
        dlg2.setOwnerActivity(MainActivity.this);
        dlg2.setCanceledOnTouchOutside(false);

        final EditText etname = dlg2.findViewById(R.id.etName);
        Button btnok = dlg2.findViewById(R.id.btnOk);
        Button btncan = dlg2.findViewById(R.id.btnCancel);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = etname.getText().toString();
                tvresult.setText(str);
                dlg2.dismiss();     //다이얼로그 객체 제거
            }
        });

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg2.dismiss();
            }
        });

        //다이얼로그가 등장할때 호출되는 메소드
        dlg2.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                etname.setText("");
            }
        });


    }

    public void showDialog1(View v){
        dlg1.show();    //다이얼로그 띄우기
    }

    public void showDialog2(View v){
        dlg2.show();
    }



}
