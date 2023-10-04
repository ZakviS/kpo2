package com.example.fxtest.Service;


import com.example.fxtest.model.Ingredient;
import com.example.fxtest.model.Salad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.fxtest.Service.stat.*;

//BasicSalad
public class VgSaladController extends saladController implements Serializable,Salad {
    ValidInsert vi = new ValidInsert();
    List<Ingredient> ingredients = new ArrayList<Ingredient>();

    public VgSaladController(List<Ingredient> ingredients) {

        this.ingredients = ingredients;
    }

    @Override
    public double calculateCalories() {
        double totalCalories = 0;
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getCalories();
        }
        return totalCalories;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Ingredient> getSalad() {
        return ingredients;
    }

    public void addOnion(int weight){

        AddOnion(weight, vi, ingredients);

    }

    public void addCucumber(int weight){

        AddCucumber(weight, vi, ingredients);


    }

    public void addTomato(int weight){

        AddTomato(weight, vi, ingredients);

    }




}
