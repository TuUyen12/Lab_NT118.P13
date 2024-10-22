package com.example.nt118_lethituuyen_22521639_lab3_1;

public class Contact {
    private int id;
    private String name;
    private String phone;

    public Contact() {}

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
