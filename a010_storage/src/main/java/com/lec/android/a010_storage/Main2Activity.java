package com.lec.android.a010_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 외부 메모리 (External Memory 혹은 Shared storage)
 *      사용자 영역 에 저장 ( sdcard 같은 외장 메모리를 의미하는게 아니다)
 *      메모리가 장착(mount)되어 있어야 사용 가능
 *      모든 앱에서 접근 가능 (공유 가능)
 *
 * 외부 메모리에 파일 읽기/쓰기
 *      1. 외부 메모리 장치가 있는지 확인해야한다 :  getExternalStorageState()
 *      2-1 AndroidManifest.xml 외부메모리 저장권한을 선언해야 함  (API 23 이전 버젼)
 *              WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE
 *      2-2 API 23+ (마시멜로): 새로운 권한 획득 방법 사용.
 *          Run-time 에 onRequestPermissionsResult() 사용 해야 한다!!!
 *          https://developer.android.com/training/permissions/requesting.html
 *
 *     3. 읽기/쓰기 경로를 지정한다
 */




public class Main2Activity extends AppCompatActivity {
    EditText etInput;
    Button btnSave, btnRead;
    TextView tvResult;

    //persmissions
    final String [] PERMISSONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etInput = findViewById(R.id.etInput);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);





        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            checkSelfPermission(String.valueOf(PERMISSONS)) == PackageManager.PERMISSION_DENIED){
//            requestPermissions(PERMISSONS, REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){

        }

    }









}
