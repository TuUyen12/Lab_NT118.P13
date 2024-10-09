package com.example.lab2_nt118;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_nt118.Employee;
import com.example.lab2_nt118.EmployeeFullTime;
import com.example.lab2_nt118.EmployeePartTime;
import com.example.lab2_nt118.R;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {
    private EditText et_ma_nv, et_ten_nv;
    private RadioGroup rg_loainv;
    private Button btn_nhapnv;
    private ListView lvPerson;
    private TextView tvSelected;

    // Ds nhân viên
    private ArrayList<Employee> employees;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3_layout);

        et_ma_nv = findViewById(R.id.et_ma_nv);
        et_ten_nv = findViewById(R.id.et_ten_nv);
        rg_loainv = findViewById(R.id.rg_loainv);
        tvSelected = findViewById(R.id.tv_selected);

        employees = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);

        btn_nhapnv = findViewById(R.id.btn_nhapnv);
        btn_nhapnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });

        lvPerson = findViewById(R.id.lv_person);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedItem = arr.get(i);
                tvSelected.setText("Position: " + i + " - Value: " + selectedItem);
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

    // Phương thức thêm nhân viên mới
    public void addNewEmployee() {
        int radId = rg_loainv.getCheckedRadioButtonId();
        String id = et_ma_nv.getText().toString();
        String name = et_ten_nv.getText().toString();

        Employee employee;
        if (radId == R.id.rb_chinh_thuc) {
            employee = new EmployeeFullTime(id, name);
        } else if (radId == R.id.rb_thoi_vu) {
            employee = new EmployeePartTime(id, name);
        } else {
            return;
        }
        employees.add(employee);
        adapter.add(employee.toString());
        adapter.notifyDataSetChanged();
        et_ten_nv.setText("");
        et_ma_nv.setText("");
        rg_loainv.clearCheck();
    }
}
