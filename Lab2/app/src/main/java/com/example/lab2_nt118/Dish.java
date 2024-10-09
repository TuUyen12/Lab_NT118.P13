package com.example.lab2_nt118;

public class Dish {
    private String ten_mon;
    private int thumbnail;
    private boolean promotion;

    public Dish(String ten_mon, int thumbnail, boolean promotion) {
        this.ten_mon = ten_mon;
        this.thumbnail = thumbnail;
        this.promotion = promotion;
    }
    public String getName() {
        return ten_mon;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public boolean hasPromotion() {
        return promotion;
    }
}
