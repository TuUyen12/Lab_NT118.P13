package com.example.lab2_nt118;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai4Activity extends AppCompatActivity {

    private EditText etId, etFullName;
    private CheckBox cbIsManager;
    private Button btnAdd;
    private ListView lvEmployee;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> listEmployee;
    private ArrayList<Boolean> listManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4_layout);

        // Khởi tạo các view
        etId = findViewById(R.id.et_id);
        etFullName = findViewById(R.id.et_fullname);
        cbIsManager = findViewById(R.id.cb_isManager);
        lvEmployee = findViewById(R.id.lv_employee);

        listEmployee = new ArrayList<>();
        listManager = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(this, R.layout.item_employee, listEmployee, listManager);
        lvEmployee.setAdapter(employeeAdapter);


        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String fullName = etFullName.getText().toString();
                boolean isManager = cbIsManager.isChecked();


                Employee newEmployee = new EmployeePartTime(id, fullName);
                listEmployee.add(newEmployee);
                listManager.add(isManager);
                employeeAdapter.notifyDataSetChanged();
                etFullName.setText("");
                etId.setText("");
                cbIsManager.setChecked(false);
            }
        });
    }
}
