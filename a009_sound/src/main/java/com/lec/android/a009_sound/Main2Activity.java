package com.lec.android.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

    private ImageButton btnPlay;
    private ImageButton btnStop;
    private ImageButton btnResume;
    private ImageButton btnPause;
    SeekBar sb;
    MediaPlayer mp;
    int pos;    //재생 위치 담을 변수
    boolean istracking = false;


    class MyThread extends Thread{
        public void run(){
            // SeekBar가 음악 재생시, 움직이게 하기
            while (mp.isPlaying()){ //현재 재생중이면
                pos = mp.getCurrentPosition();    //현재 재생중인 위치 ms(int)
                if(!istracking){    //seekbar가 움직이면
                    sb.setProgress(pos);    //seekbar 이동 --> onprogresschanged 호출
                }

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnStop = findViewById(R.id.btnStop);
        sb = findViewById(R.id.sb);

        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.VISIBLE);
        btnStop.setVisibility(View.VISIBLE);
        btnResume.setVisibility(View.VISIBLE);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //sb 값이 변경될땜다 호출
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //음악이 끝까지 재생 완료 되었다묜
                if(seekBar.getMax() == progress && !fromUser){

                    btnPlay.setVisibility(View.VISIBLE);
                    btnPause.setVisibility(View.INVISIBLE);
                    btnStop.setVisibility(View.INVISIBLE);
                    btnResume.setVisibility(View.INVISIBLE);

                    if(mp != null){
                        mp.stop();
                    }
                }
            }

            //드래그 시작 (트랙킹) 하면 호출
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                istracking = true;
            }

            //드래그 마치면 (트랙킹 종료) 호출
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                pos = seekBar.getProgress();

                if(mp != null) mp.seekTo(pos);  //사용자가 손을 떈 위치로 이동

                istracking = false;
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(
                        getApplicationContext(),    //현재 화면의 제어권자
                        R.raw.chacha    //음악 파일 리소스
                );
                mp.setLooping(false);   //true : 무한반복

                //재생이 끝나면 호출되는 콜백 메소드
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Log.d("myapp" , "노래종료" + mp.getCurrentPosition() + "/" + mp.getDuration());
                        btnPlay.setVisibility(View.VISIBLE);
                        btnPause.setVisibility(View.INVISIBLE);
                        btnStop.setVisibility(View.INVISIBLE);
                        btnResume.setVisibility(View.INVISIBLE);
                    }
                });

                mp.start(); //노래재생시작

               int dur = mp.getDuration();//음악의 재생시간 (ms)
                sb.setMax(dur);//seekbar 의 범위를 음악의 재생시간으로 설정
                new MyThread().start();//seekbar 쓰레드 시작

                btnPlay.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.VISIBLE);


            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //음악 종료
                pos = 0;
                if(mp!= null){
                    mp.stop();
                    mp.seekTo(0);   //음악의 처음으로 이동
                    mp.release();   //자원해제
                    mp = null;
                }

                sb.setProgress(0);  //seekbar 초기화

                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
            }
        });

        //일시중지
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = mp.getCurrentPosition();  //현재 재생중이던 위치 저장
                mp.pause(); //일시정지

                btnPause.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
            }
        });

        //멈춘 시점부터 재시작
        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.seekTo(pos); //일시정지에서 기록해둔 위치로 이동
                mp.start(); //재생시작
                new MyThread().start(); //seekbar 쓰레드 이동 시작
                btnPause.setVisibility(View.VISIBLE);
                btnResume.setVisibility(View.INVISIBLE);

            }
        });


    }// end create

    protected  void onPause() {

        super.onPause();

        if(mp != null){
            mp.release();   //자원해체
        }

        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
    }
}
