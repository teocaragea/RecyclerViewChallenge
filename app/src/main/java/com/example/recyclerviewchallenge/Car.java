package com.example.recyclerviewchallenge;

public class Car {
    private String Make;
    private String Name;
    private String Number;
    private String Model;

    public Car(String make, String name, String number, String model) {
        Make = make;
        Name = name;
        Number = number;
        Model = model;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
