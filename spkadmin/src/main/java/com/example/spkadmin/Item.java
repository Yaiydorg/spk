package com.example.spkadmin;

public class Item {
    String name;
    String icnumber;
    int image;

    public Item(String name, String icnumber, int image) {
        this.name = name;
        this.icnumber = icnumber;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcnumber() {
        return icnumber;
    }

    public void setIcnumber(String icnumber) {
        this.icnumber = icnumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
