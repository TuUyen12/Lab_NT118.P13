package com.example.lab2_nt118;

// Class con EmployeeFullTime kế thừa từ Employee
public class EmployeeFullTime extends Employee {

    public EmployeeFullTime(String id, String name) {
        super(id, name); // Gọi constructor của lớp cha
    }
    // Ghi đè phương thức tinhLuong
    @Override
    public double TinhLuong() {
        return 500.0;
    }

    // Ghi đè phương thức toString nếu cần thiết
    @Override
    public String toString() {
        return super.toString() + " FullTime = " + TinhLuong(); // Thêm thông tin lương
    }
}
