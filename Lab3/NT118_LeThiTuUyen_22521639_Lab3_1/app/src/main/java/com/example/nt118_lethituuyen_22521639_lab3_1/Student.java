package com.example.nt118_lethituuyen_22521639_lab3_1;

public class Student {
    private String id;
    private String name;
    private String birthDate; // Thay đổi từ age sang birthDate
    private String address;
    private String phone;

    public Student() {}

    public Student(String id, String name, String birthDate, String address, String phone) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate; // Sử dụng birthDate
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() { // Phương thức getter cho birthDate
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) { // Phương thức setter cho birthDate
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
