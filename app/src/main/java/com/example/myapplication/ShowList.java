package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ShowList extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button;
    DB_Handler database;
    List<model> list;
    CustomAdepter customAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        getIntent();

        database = new DB_Handler(ShowList.this);
        recyclerView = findViewById(R.id.rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        list = database.getData();

        customAdepter = new CustomAdepter(ShowList.this,list);
        recyclerView.setAdapter(customAdepter);

        button = findViewById(R.id.add);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(ShowList.this,AddNew.class);
            startActivity(intent);
        });

        //LOG
        for(model mt : list){
            Log.d("SQLITE" , "This is id : " + mt.getId() + "\n"
                    + "Name =  : " + mt.getName() +  "\n"
                    + "Price = : " + mt.getPrice() + "\n");
        }


    }

}