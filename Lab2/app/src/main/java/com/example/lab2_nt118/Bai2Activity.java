package com.example.lab2_nt118;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai2Activity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_layout);

        ListView lvPerson = findViewById(R.id.lv_person);
        TextView tvSelected = findViewById(R.id.tv_selected);
        EditText etNhap = findViewById(R.id.et_nhap);
        Button btnNhap = findViewById(R.id.btn_nhap);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Teo");
        arr.add("Ty");
        arr.add("Bin");
        arr.add("Bo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedItem = arr.get(i);
                tvSelected.setText("Position: " + i + " - Value: " + selectedItem);
            }
        });
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = etNhap.getText().toString();
                if (content != null) {
                    arr.add(content);
                }
                adapter.notifyDataSetChanged();
                etNhap.setText(" ");
            }
        });
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
