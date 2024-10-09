package com.example.lab2_nt118;

public class EmployeePartTime extends Employee {

    public EmployeePartTime(String id, String name) {
        super(id, name); // Gọi constructor của lớp cha
    }
    // Ghi đè phương thức tinhLuong
    @Override
    public double TinhLuong() {
        return 150.0;
    }

    // Ghi đè phương thức toString nếu cần thiết
    @Override
    public String toString() {
        return super.toString() + " PartTime = " + TinhLuong(); // Thêm thông tin lương
    }
}
