package com.example.nt118_lethituuyen_22521639_lab3_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai2Activity extends AppCompatActivity {

    private ArrayList<String> contactList;
    private ArrayAdapter<String> adapter;
    private DatabaseHandler db;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_activity);

        // Khởi tạo DatabaseHandler
        db = new DatabaseHandler(this);

        // Thêm dữ liệu vào Database (kiểm tra nếu chưa tồn tại)
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));


        // Đọc tất cả các contact từ database
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        // Tạo danh sách để hiển thị trên ListView
        ArrayList<String> contactList = new ArrayList<>();
        for (Contact cn : contacts) {
            Log.e("Name:", "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone());
            contactList.add(cn.getName() + " - " + cn.getPhone());
        }

        // Ánh xạ ListView từ layout
        ListView lvContact = findViewById(R.id.lv_contacts);

        // Tạo Adapter và gán dữ liệu cho ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactList);
        lvContact.setAdapter(adapter);

        // Thiết lập sự kiện long click để xóa contact
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Xóa contact từ Database
                Contact contactToDelete = contacts.get(position);
                db.deleteContact(contactToDelete);

                // Xóa contact khỏi danh sách hiển thị
                contacts.remove(position);
                contactList.remove(position);
                adapter.notifyDataSetChanged(); // Cập nhật lại ListView

                // Hiển thị thông báo xóa thành công
                Toast.makeText(Bai2Activity.this, "Đã xóa " + contactToDelete.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
