package com.example.fxtest.Service;

import com.example.fxtest.model.*;


import java.util.List;

public class stat {
    static void AddOnion(int weight, ValidInsert vi, List<Ingredient> salad) {
        if (vi.searchName(salad,"Onion")){
            salad.get(vi.searchId(salad,"Onion")).setWeight(salad.get(vi.searchId(salad,"Onion")).getWeight() + weight);
            double call = weight *0.4;
            salad.get(vi.searchId(salad,"Onion")).setCalories(salad.get(vi.searchId(salad,"Onion")).getCalories() + call);
        }else {
            Onion onion = new Onion("Onion", weight, 0.4);
            salad.add(onion);
        }
    }

    static void AddCucumber(int weight, ValidInsert vi, List<Ingredient> salad) {
        if (vi.searchName(salad,"Cucumber")){
            salad.get(vi.searchId(salad,"Cucumber")).setWeight(salad.get(vi.searchId(salad,"Cucumber")).getWeight() + weight);
            double call = weight * 0.16;
            salad.get(vi.searchId(salad,"Cucumber")).setCalories(salad.get(vi.searchId(salad,"Cucumber")).getCalories() + call);
        }else {
            Cucumber cucumber = new Cucumber("Cucumber", weight, 0.16);
            salad.add(cucumber);
        }
    }

    static void AddTomato(int weight, ValidInsert vi, List<Ingredient> salad) {
        if (vi.searchName(salad,"Tomato")){
            salad.get(vi.searchId(salad,"Tomato")).setWeight(salad.get(vi.searchId(salad,"Tomato")).getWeight() + weight);
            double call = weight * 0.2;
            salad.get(vi.searchId(salad,"Tomato")).setCalories(salad.get(vi.searchId(salad,"Tomato")).getCalories() + call);
        }else {
            Tomato tomato = new Tomato("Tomato", weight, 0.2);
            salad.add(tomato);
        }
    }

    static void AddChicken(int weight, ValidInsert vi, List<Ingredient> salad) {
        if (vi.searchName(salad,"Chicken")){
            salad.get(vi.searchId(salad,"Chicken")).setWeight(salad.get(vi.searchId(salad,"Chicken")).getWeight() + weight);
            double call = weight * 1.17;
            salad.get(vi.searchId(salad,"Chicken")).setCalories(salad.get(vi.searchId(salad,"Chicken")).getCalories() + call);
        }else {
            Chicken chicken = new Chicken("Chicken", weight, 1.17);
            salad.add(chicken);
        }
    }

    static void AddTurkey(int weight, ValidInsert vi, List<Ingredient> salad) {
        if (vi.searchName(salad,"Turkey")){
            salad.get(vi.searchId(salad,"Turkey")).setWeight(salad.get(vi.searchId(salad,"Turkey")).getWeight() + weight);
            double call = weight * 1.35;
            salad.get(vi.searchId(salad,"Turkey")).setCalories(salad.get(vi.searchId(salad,"Turkey")).getCalories() + call);
        }else {
            Turkey turkey = new Turkey("Turkey", weight, 1.35);
            salad.add(turkey);
        }
    }
}
