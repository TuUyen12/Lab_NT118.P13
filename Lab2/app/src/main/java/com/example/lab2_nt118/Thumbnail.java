package com.example.lab2_nt118;

public enum Thumbnail {
    ThumbnaiL1("Thumbnail 1", R.drawable.banhcuon),
    ThumbnaiL2("Thumbnail 2", R.drawable.banhmi),
    ThumbnaiL3("Thumbnail 3", R.drawable.goicuon),
    ThumbnaiL4("Thumbnail 4", R.drawable.phobo);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }
    public String getName(){
        return name;
    }
    public int getImg(){
        return img;
    }
}
