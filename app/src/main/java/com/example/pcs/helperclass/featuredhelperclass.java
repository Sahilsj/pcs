package com.example.pcs.helperclass;

public class featuredhelperclass {
    int image;
    String title, descrption;

    public featuredhelperclass(int image, String title, String descrption) {
        this.image = image;
        this.title = title;
        this.descrption = descrption;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrption() {
        return descrption;
    }
}
