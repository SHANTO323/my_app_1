package com.example.myapplication;

public class model {
    private int Id;
    private String Name;
    private String Price;

    public model(String name, String price) {
        Name = name;
        Price = price;
    }

    public model() {
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
