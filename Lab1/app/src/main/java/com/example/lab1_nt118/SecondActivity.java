package com.example.lab1_nt118;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Liên kết với file activity_second.xml

        Button OpenLinearLayout = findViewById(R.id.btn_linear);
        OpenLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, LinearActivity.class);
                startActivity(intent);
            }
        });
        Button OpenRelativeLayout = findViewById(R.id.btn_relative);
        OpenRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, RelativeActivity.class);
                startActivity(intent);
            }
        });

        Button OpenConstraintLayout = findViewById(R.id.btn_constraint);
        OpenConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, RelativeActivity.class);
                startActivity(intent);
            }
        });
    }
}
