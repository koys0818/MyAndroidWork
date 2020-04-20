package com.lec.android.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;


/*  음향: SoundPool
 *      짧은 음향 리소스(들)을 SoundPool 에 등록(load)하고, 원할때마다 재생(play)
 *
 *  res/raw 폴더 만들고  음향 리소스 추가하기
 */


public class MainActivity extends AppCompatActivity {

    private SoundPool sp;

    //음향 리소스 id
    private  final int [] SOUND_RES = {R.raw.gun ,R.raw.gun2, R.raw.gun3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay1 = findViewById(R.id.btnPlay);
        Button btnPlay2 = findViewById(R.id.btnPlay2);
        Button btnPlay3 = findViewById(R.id.btnPlay3);

        //Soundpool 객체 생성

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //API 21이상에서는 아래와 같이 soundpool 생성
            sp = new SoundPool.Builder().setMaxStreams(10).build();
        } else {


            sp = new SoundPool(1,   //재생 음향 최대 개수
                    AudioManager.STREAM_MUSIC,  // 재생 미디어 타입
                    0);               //재생 품질 (안쓰임 디폴트 0)

        }


        for(int i = 0 ; i < SOUND_RES.length;i++){


        }


    }
}
