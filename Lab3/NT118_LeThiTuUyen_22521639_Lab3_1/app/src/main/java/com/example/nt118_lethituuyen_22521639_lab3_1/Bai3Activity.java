package com.example.nt118_lethituuyen_22521639_lab3_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Bai3Activity extends AppCompatActivity implements StudentAdapter.OnStudentClickListener {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private StudentDatabaseHandler db;

    private EditText etStudentId, etStudentName, etStudentBirthday, etStudentAddress, etStudentPhone;
    private Button btnAddStudent, btnDeleteStudent, btnEditStudent;

    private int selectedPosition = -1;  // Biến để lưu vị trí sinh viên được chọn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3_activity);

        // Khởi tạo DatabaseHandler và lấy danh sách sinh viên
        db = new StudentDatabaseHandler(this);
        studentList = db.getAllStudents();

        // Thiết lập RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo Adapter
        studentAdapter = new StudentAdapter(this, studentList, this);
        recyclerView.setAdapter(studentAdapter);

        // Khởi tạo các view cho form thêm sinh viên và các nút
        etStudentId = findViewById(R.id.et_student_id);
        etStudentName = findViewById(R.id.et_student_name);
        etStudentBirthday = findViewById(R.id.et_student_birthday); // Đảm bảo trường này đúng
        etStudentAddress = findViewById(R.id.et_student_address);
        etStudentPhone = findViewById(R.id.et_student_phone);

        btnAddStudent = findViewById(R.id.btn_add_student);
        btnDeleteStudent = findViewById(R.id.btn_delete_student);
        btnEditStudent = findViewById(R.id.btn_edit_student);

        // Xử lý sự kiện thêm sinh viên
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });

        // Xử lý sự kiện xóa sinh viên
        btnDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteStudent();
            }
        });

        // Xử lý sự kiện sửa thông tin sinh viên
        btnEditStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent();
            }
        });
    }

    private void addStudent() {
        // Lấy dữ liệu từ EditText
        String studentId = etStudentId.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String birthday = etStudentBirthday.getText().toString().trim(); // Thay đổi biến age thành birthday
        String address = etStudentAddress.getText().toString().trim();
        String phone = etStudentPhone.getText().toString().trim();

        if (studentId.isEmpty() || name.isEmpty() || birthday.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Thêm sinh viên mới vào cơ sở dữ liệu
        Student newStudent = new Student(studentId, name, birthday, address, phone); // Cập nhật constructor
        db.addStudent(newStudent);
        studentList.add(newStudent);
        studentAdapter.notifyDataSetChanged();

        // Reset form
        resetForm();
        Toast.makeText(this, "Đã thêm sinh viên!", Toast.LENGTH_SHORT).show();
    }

    private void deleteStudent() {
        if (selectedPosition >= 0) {
            Student studentToDelete = studentList.get(selectedPosition);
            db.deleteStudent(studentToDelete);
            studentList.remove(selectedPosition);
            studentAdapter.notifyDataSetChanged();
            selectedPosition = -1;  // Reset vị trí sinh viên đã chọn
            resetForm();
            Toast.makeText(this, "Đã xóa sinh viên!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vui lòng chọn sinh viên để xóa!", Toast.LENGTH_SHORT).show();
        }
    }

    private void editStudent() {
        if (selectedPosition >= 0) {
            Student studentToEdit = studentList.get(selectedPosition);
            studentToEdit.setId(etStudentId.getText().toString().trim());
            studentToEdit.setName(etStudentName.getText().toString().trim());
            studentToEdit.setBirthDate(etStudentBirthday.getText().toString().trim()); // Cập nhật để sử dụng ngày tháng
            studentToEdit.setAddress(etStudentAddress.getText().toString().trim());
            studentToEdit.setPhone(etStudentPhone.getText().toString().trim());

            db.updateStudent(studentToEdit);
            studentAdapter.notifyDataSetChanged();
            selectedPosition = -1;
            resetForm();
            Toast.makeText(this, "Đã cập nhật thông tin sinh viên!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vui lòng chọn sinh viên để sửa!", Toast.LENGTH_SHORT).show();
        }
    }

    // Hàm reset form
    private void resetForm() {
        etStudentId.setText("");
        etStudentName.setText("");
        etStudentBirthday.setText(""); // Đổi từ etStudentAge thành etStudentBirthday
        etStudentAddress.setText("");
        etStudentPhone.setText("");
    }

    @Override
    public void onStudentClick(int position) {
        selectedPosition = position;  // Lưu vị trí sinh viên đã chọn
        Student clickedStudent = studentList.get(position);
        etStudentId.setText(clickedStudent.getId());
        etStudentName.setText(clickedStudent.getName());
        etStudentBirthday.setText(clickedStudent.getBirthDate()); // Cập nhật để lấy ngày tháng
        etStudentAddress.setText(clickedStudent.getAddress());
        etStudentPhone.setText(clickedStudent.getPhone());
    }

    @Override
    public void onStudentLongClick(int position) {
        // Xử lý khi người dùng nhấn giữ vào một sinh viên
        Student studentToDelete = studentList.get(position);
        db.deleteStudent(studentToDelete);  // Xóa sinh viên khỏi cơ sở dữ liệu
        studentList.remove(position);  // Xóa sinh viên khỏi danh sách
        studentAdapter.notifyItemRemoved(position);  // Cập nhật RecyclerView
        Toast.makeText(this, "Đã xóa sinh viên: " + studentToDelete.getName(), Toast.LENGTH_SHORT).show();
    }
}
