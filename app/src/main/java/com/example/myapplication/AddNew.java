package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddNew extends AppCompatActivity {

    public void back(View view){
        Intent intent = new Intent(this,ShowList.class);
        startActivity(intent);
    }
    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        Button button = findViewById(R.id.Click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddNew.this, "item added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddNew.this,ShowList.class);
                startActivity(intent);
                TextView textView1 = findViewById(R.id.Item);
                TextView textView2 = findViewById(R.id.price);
                String name = textView1.getText().toString();
                String price = textView2.getText().toString() + " TK";
                DB_Handler myDB = new DB_Handler(AddNew.this);
                model add = new model(name , price);
                myDB.addDatabase(add);
            }
        });
    }
}