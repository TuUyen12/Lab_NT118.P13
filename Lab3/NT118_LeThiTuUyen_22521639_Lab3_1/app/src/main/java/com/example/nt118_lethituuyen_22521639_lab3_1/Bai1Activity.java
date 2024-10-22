package com.example.nt118_lethituuyen_22521639_lab3_1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nt118_lethituuyen_22521639_lab3_1.adapter.DbAdapter;

import java.util.ArrayList;
import java.util.List;

public class Bai1Activity extends AppCompatActivity {
    private DbAdapter dbAdapter;
    private Cursor cursor;
    private List<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_activity);
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        dbAdapter.deleteAllUsers();
        for (int i = 0; i < 10; i++) {
            dbAdapter.createUser("Lê Thị Tú Uyên " + i);
        }
        users = getData();
        showData();

    }
    private List<String> getData() {
        List<String> users = new ArrayList<>();
        Cursor cursor = dbAdapter.getAllUsers(); // Lấy dữ liệu từ cơ sở dữ liệu

        // Kiểm tra xem cursor có hợp lệ và có dữ liệu không
        if (cursor != null && cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndexOrThrow(DbAdapter.KEY_NAME); // Sử dụng getColumnIndexOrThrow để bắt lỗi
            do {
                // Thêm tên người dùng vào danh sách
                users.add(cursor.getString(nameIndex));
            } while (cursor.moveToNext());
            cursor.close(); // Đóng cursor sau khi sử dụng
        }

        return users; // Trả về danh sách người dùng
    }

    private void showData() {
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        ArrayAdapter<String> userAdapter = new
                ArrayAdapter<String>(Bai1Activity.this, R.layout.item_user, users);
        lvUser.setAdapter(userAdapter);
    }
}
