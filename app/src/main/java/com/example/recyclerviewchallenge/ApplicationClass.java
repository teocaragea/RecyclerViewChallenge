package com.example.recyclerviewchallenge;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public  static ArrayList<Car> cars;


    @Override
    public void onCreate() {
        super.onCreate();
        cars=new ArrayList<Car>();
        cars.add(new Car("nissan","Borris","07855353","Almera"));
        cars.add(new Car("volkswagen","Carl Lindegen","072460353","Golf V"));
        cars.add(new Car("mercedes","Ion Schiopu","074463656","S560"));
        cars.add(new Car("volkswagen","John Rambo","023685353","Polo"));
        cars.add(new Car("mercedes","teo caragea","0634353","E63"));


    }


}
