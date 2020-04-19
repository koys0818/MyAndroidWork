package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    AddressAdapter adapter;
    RecyclerView rv;
    EditText etname,etage,etaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etaddress = findViewById(R.id.etaddress);
        etage = findViewById(R.id.etage);
        etname = findViewById(R.id.etname);

        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(layoutManager);

        adapter = new AddressAdapter();
        initAdapter(adapter);

        rv.setAdapter(adapter);

        Button btnin = findViewById(R.id.btnin);

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });





    }//end create

    protected void initAdapter(AddressAdapter adapter){
        for (int i = 0 ; i < 10; i++){

            int idx = Example.next();
            adapter.addItem(new AddressBook(Example.NAME[idx], Example.AGE[idx], Example.ADDRESS[idx]));
        }
    }

    protected void insertData(View v){


        adapter.addItem(0, new AddressBook( etname.getText().toString(), etage.getText().toString(), etaddress.getText().toString()));
        adapter.notifyDataSetChanged();
    }




}//end class
