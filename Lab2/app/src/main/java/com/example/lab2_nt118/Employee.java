package com.example.lab2_nt118;

import androidx.annotation.Nullable;

public abstract class Employee {
    private String id;
    private String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    // Phương thức ảo tính lương
    public abstract double TinhLuong();


    @Override
    public String toString() {
        return id + " - " + name + "-->";
    }

}
