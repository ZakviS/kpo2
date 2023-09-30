package com.example.fxtest.model;

import java.io.Serializable;

public abstract class Ingredient implements Serializable {

    private String name;
    private double Calories;
    private int weight;
    static int id;

    public static int getId() {
        return id;
    }

    public Ingredient(String name, int weight, double k) {
        this.name = name;
        this.weight = weight;
        Calories = weight * k;
        id ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return Calories;
    }

    public void setCalories(double calories) {
        Calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString(){
        String result = String.format("\nName: %s, calories: %.1f, weight: %d",name, Calories, weight);
        return result;
    }

}
