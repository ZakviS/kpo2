package com.example.fxtest.Service;


import com.example.fxtest.model.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.fxtest.Service.stat.*;


public class VgSaladController extends saladController implements Serializable {
    ValidInsert vi = new ValidInsert();
    List<Ingredient> salad = new ArrayList<Ingredient>();

    public List<Ingredient> getSalad() {
        return salad;
    }

    public void addOnion(int weight){

        AddOnion(weight, vi, salad);

    }

    public void addCucumber(int weight){

        AddCucumber(weight, vi, salad);


    }

    public void addTomato(int weight){

        AddTomato(weight, vi, salad);

    }


}
