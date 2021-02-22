package com.edu.utez.entity;

public class EntityCar {
    private String id;
    private String model;
    private String brand;
    private int year;

    public EntityCar() {
    }

    public EntityCar(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public EntityCar(String id, String model, String brand, int year) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
