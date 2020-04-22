package com.lec.android.a013_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* ContextMenu - 뷰 객체를 롱클릭했을 때 나오는 메뉴
   PC 에서 마우스 우클릭으로 부가정보들을 제공하는 방법을
   스마트폰에서는 롱클릭의 ContextMenu 로 대체하여 구현한다
*/

public class Main2Activity extends AppCompatActivity {

    TextView tvCtxMenu;
    ImageView ivCtxMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvCtxMenu = findViewById(R.id.tvCtxMenu);
        ivCtxMenu = findViewById(R.id.ivCtxView);

        registerForContextMenu(tvCtxMenu);  //뷰객체 (위젯 등) 에 contextmenu 를 등록함
//        unregisterForContextMenu(tvCtxMenu);//뷰객체 에 등록된 contextmenu 제거




    }

    // onCreateContextMenu()
    // 컨텍스트 메뉴가  호출되는 콜백 메서드

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.d("myapp","oncreatecontextmenu()");

        //각각의 뷰 (위젯) (View v) 마다 다르게 메뉴 작동하도록 설정 가능
        switch (v.getId()){
            case R.id.tvCtxMenu:

                menu.setHeaderTitle("색상을 선택하세요");
                menu.add(0,1,100,"빨강");
                menu.add(0,2,100,"녹색");
                menu.add(0,3,100,"파랑");

                break;

            case R.id.ivCtxView:
                menu.setHeaderTitle("얼굴을 선택하세요");
                menu.add(1,1,100,"스파이더맨");
                menu.add(1,2,100,"베놈");
                menu.add(1,3,100,"아이콘");

                break;

        }

    }


    // onContextItemSelected(MenuItem)
    // ContextMenu 의 메뉴아이템 항목을 선택(클릭) 했을 때 호출


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
        showInfo(item);
        int id = item.getItemId();
        int groupid = item.getGroupId();

        switch (groupid){
            case 0:
                switch (id){
                    case 1:
                        tvCtxMenu.setTextColor(Color.RED);
                        return true;
                    case 2:




            }
                break;
            case 1:

        }
    }



    public void showInfo(MenuItem item){
        int id = item.getItemId();   // 옵션메뉴 아이템의 id 값
        String title = item.getTitle().toString();   // 옵션 메뉴의 title
        int groupId = item.getGroupId();   // 옵션 메뉴의 그룹아이디
        int order = item.getOrder();

        String msg = "id:" + id + " title:" + title + " groupid:" + groupId + " order:" + order;
        Log.d("myapp", msg);
        Toast.makeText(getApplicationContext(), title + " 메뉴 클릭", Toast.LENGTH_SHORT).show();
    }





}