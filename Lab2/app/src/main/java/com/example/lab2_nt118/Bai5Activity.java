package com.example.lab2_nt118;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai5Activity extends AppCompatActivity {
    private ArrayList<Dish> listDish;
    private DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai5_layout);

        GridView gridView = findViewById(R.id.grid_view);
        Spinner spinner = findViewById(R.id.spinner);
        EditText etTenMon = findViewById(R.id.et_tenmon);
        CheckBox cbPromotion = findViewById(R.id.cb_promotion);


        listDish = new ArrayList<>();
        dishAdapter = new DishAdapter(this, listDish);
        gridView.setAdapter(dishAdapter);

        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this);
        spinner.setAdapter(thumbnailAdapter);

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dishName = etTenMon.getText().toString().trim();

                if (dishName.isEmpty()) {
                    Toast.makeText(Bai5Activity.this, "Hãy nhập tên món!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lấy ID resource image từ thumbnail
                int selectedThumbnail = Thumbnail.values()[spinner.getSelectedItemPosition()].getImg();
                boolean hasPromotion = cbPromotion.isChecked();

                Dish newDish = new Dish(dishName, selectedThumbnail, hasPromotion);
                listDish.add(newDish);
                dishAdapter.notifyDataSetChanged();
                Toast.makeText(Bai5Activity.this, "Đã thêm món ăn", Toast.LENGTH_SHORT).show();

                etTenMon.setText("");
                cbPromotion.setChecked(false);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Không cần xử lý gì khi chọn thumbnail, đã xử lý trong nút thêm
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
