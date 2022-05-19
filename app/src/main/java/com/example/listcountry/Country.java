package com.example.listcountry;

public class Country {

    private String name;
    private String capital;
    private int image;

    public Country(String name, String capital, int image) {
        this.name = name;
        this.capital = capital;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
