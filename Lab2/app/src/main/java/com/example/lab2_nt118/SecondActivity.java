package com.example.lab2_nt118;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button Bai1 = findViewById(R.id.btn_bai1);
        Bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai1Activity.class);
                startActivity(intent);
            }

        });

        Button Bai2 = findViewById(R.id.btn_bai2);
        Bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai2Activity.class);
                startActivity(intent);
            }
        });
        Button Bai3 = findViewById(R.id.btn_bai3);
        Bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai3Activity.class);
                startActivity(intent);
            }
        });
        Button Bai4 = findViewById(R.id.btn_bai4);
        Bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai4Activity.class);
                startActivity(intent);
            }
        });

        Button Bai5 = findViewById(R.id.btn_bai5);
        Bai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai5Activity.class);
                startActivity(intent);
            }
        });
        Button Bai6 = findViewById(R.id.btn_bai6);
        Bai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, Bai6Activity.class);
                startActivity(intent);
            }
        });


    }

}

