package com.naver.koys0818.blockgame1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.TreeMap;

public class Start extends AppCompatActivity implements View.OnClickListener{

    TextView tvtime;    //시간표시
    TextView tvpoint;   //점수표시

    int time = 30;  //시간값
    int point = 0;  //점수값

    // 불럭이미지 리소스 배열
    int [] img = {R.drawable.block_red, R.drawable.block_green, R.drawable.block_blue};

    //떨어지는 블럭의 imageview 배열 객체
    ImageView[] iv = new ImageView[8];

    private Vibrator vibrator;  //진동
    private SoundPool soundPool;    //음악

    int soundID_ok; //음향 ID 블럭을 맞출때
    int soundID_Error;  //음향 ID 틀렸을때

    private MediaPlayer mp; // 배경음악

    final int DIALOG_TIMEOVER = 1;  //다이얼로그 ID

    Handler handler = new Handler();    //시간

    // 게임진행 쓰레드
    class Gamethread extends Thread{
        @Override
        public void run() {
           //시간은 1초마다 다시 표시(업데이트)
            // Handler 사용하여 화면 UI 업데이트

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(time>= 0){
                        tvtime.setText("시간 : " + time);

                        if(time > 0){
                            time--;     //1초 감소, 1초후에 다시 run()  수행
                        }else {
                            //time => 0이 된 경우
                            AlertDialog.Builder builder
                                    = new AlertDialog.Builder(Start.this);
                            builder.setTitle("타임아웃")
                                    .setMessage("점수 : " + point)
                                    .setNegativeButton("그만하기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                        }
                                    })
                                    .setPositiveButton("다시하기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            time = 30;
                                            point = 0;
                                            tvtime.setText("시간 : " + time);
                                            tvpoint.setText("점수 : " + point);
                                            new Gamethread().start();   //새로운 게임 시작
                                        }
                                    });
                            builder.show();
                        }
                        handler.postDelayed(this, 1000);
                    }

                }
            }, 1000);   //1초후에 시간표시

        }


    }//end gamethread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상태바 없에기   반드시 setcontentview앞에서 처리
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.start);

        tvtime = findViewById(R.id.tvTime);
        tvpoint = findViewById(R.id.tvPoint);

        ImageView ivred = findViewById(R.id.ivred);
        ImageView ivgreen = findViewById(R.id.ivgreen);
        ImageView ivblue = findViewById(R.id.ivblue);

        iv[0] = findViewById(R.id.ivblock1);
        iv[1] = findViewById(R.id.ivblock2);
        iv[2] = findViewById(R.id.ivblock3);
        iv[3] = findViewById(R.id.ivblock4);
        iv[4] = findViewById(R.id.ivblock5);
        iv[5] = findViewById(R.id.ivblock6);
        iv[6] = findViewById(R.id.ivblock7);
        iv[7] = findViewById(R.id.ivblock8);

        //게임이 시작되면 초기화 ,랜덤으로 블럭의 색상 지정
       for(int i = 0; i < iv.length;i++){
           // 0 1 2 <-- red green blue
           int num = new Random().nextInt(3);   /// 0 1 2중 랜덤값
           iv[i].setImageResource(img[num]);
           iv[i].setTag(num + "");  //태그를 버튼의 색상 판단하기 위해
       }

       //점수 초기화
        point = 0;
       tvpoint.setText("점수 : " + point);

       //r g b 버튼의 이벤트 리스너 등록
        ivred.setOnClickListener(this); //자기자신을 implements 했으니까
        ivgreen.setOnClickListener(this);
        ivblue.setOnClickListener(this);

        //시간 표시 게임진행 쓰레드 시작하기
        new Gamethread().start();



    }//end create


    @Override
    public void onClick(View v) {
        //버튼을 눌렀을떄 호출되는 콜백
        //블럭과 같은 색깔의 버튼이 눌렸는지 판별, 같은 블럭이면 이미지 블럭 한칸씩 내려오기, 맨위에 새로운 블록 생성

        boolean isok = false;   ///맞추었는지 판별 결과

        ImageView imageView = (ImageView) v;

        switch (imageView.getId()){
            //맨 아래 블럭의 색상과 일치하는 버튼인지 판정
            case R.id.ivred:    //빨강버튼 클릭시
                if("0".equals(iv[7].getTag().toString())) isok = true;
                break;

            case R.id.ivgreen:
                if("1".equals(iv[7].getTag().toString())) isok = true;
                break;


            case R.id.ivblue:
                if("2".equals(iv[7].getTag().toString())) isok = true;
                break;


        }
        if(isok){   // 색깔을 맞추었다면

            //위의 7개블럭을 한칸 아래로 이동
            for(int i = iv.length - 2 ; i>=0; i--){
                int num = Integer.parseInt(iv[i].getTag().toString());
                iv[i+1].setImageResource(img[num]); //  아랫쪽블럭 이미지 업데이트
                iv[i + 1].setTag(num + ""); //tag값 업데이트
            }

            //가장 위의 블럭 랜덤으로 생성
            int num = new Random().nextInt(3);
            iv[0].setImageResource(img[num]);
            iv[0].setTag(num + "");

            //진동 음향
            vibrator.vibrate(200);
            soundPool.play(soundID_ok,1,1,0,0,1);

            //점수올리기
            point++;
            tvpoint.setText("점수 : " + point);


        }else{  // 틀렸다면
            vibrator.vibrate(new long[] {20,80,20,80,20}, -1);
            soundPool.play(soundID_ok,1,1,0,0,1);

            //점수깍기
            point--;
            tvpoint.setText("점수 : " + point);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        // 자원획득
        //TODO
        //vibratar 객체 얻어오기
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        //SoundPool 객체
        soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        soundID_ok = soundPool.load(Start.this,R.raw.gun3,1);
        soundID_Error = soundPool.load(Start.this,R.raw.error,1);

        //MediaPlayer 객체 배경음악 시작
        mp = MediaPlayer.create(getApplicationContext(),R.raw.bgm);
        mp.setLooping(false);   //반복재생 안함
        mp.start(); //배경음악 시작
    }


    @Override
    protected void onPause() {
        super.onPause();
        // 자원해제
        if(mp != null){
            mp.stop();
            mp.release();
        }
    }
}//end Activity







