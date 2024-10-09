package com.example.lab2_nt118;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bai6Activity extends AppCompatActivity {

    private EditText etId, etFullName;
    private CheckBox cbIsManager;
    private Button btnAdd;
    private RecyclerView rvEmployees;
    private EmployeeRecyclerAdapter employeeAdapter;
    private ArrayList<Employee> listEmployee;
    private ArrayList<Boolean> listManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai6_layout);

        etId = findViewById(R.id.et_id);
        etFullName = findViewById(R.id.et_fullname);
        cbIsManager = findViewById(R.id.cb_isManager);
        rvEmployees = findViewById(R.id.rv_employees);

        listEmployee = new ArrayList<>();
        listManager = new ArrayList<>();

        employeeAdapter = new EmployeeRecyclerAdapter(this, listEmployee, listManager);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));
        rvEmployees.setAdapter(employeeAdapter);

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

                etId.setText("");
                etFullName.setText("");
                cbIsManager.setChecked(false);
            }
        });
    }
}
