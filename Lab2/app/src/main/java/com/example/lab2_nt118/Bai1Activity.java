package com.example.lab2_nt118;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Bai1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_layout);


        ListView lvPerson = findViewById(R.id.lv_person);
        TextView tvSelected = findViewById(R.id.tv_selected);
        String arr[] = {"Teo", "Ty", "Bin", "Bo"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Cập nhật TextView với vị trí và giá trị phần tử được chọn
                String selectedItem = arr[position];
                tvSelected.setText("Position: " + position + " - Value: " + selectedItem);
            }
        });
    }
}
