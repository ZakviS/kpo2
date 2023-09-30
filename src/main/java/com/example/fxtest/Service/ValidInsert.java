package com.example.fxtest.Service;

import com.example.fxtest.model.Ingredient;

import java.util.List;

public class ValidInsert {

    List<Ingredient> salad;

    public boolean ValidWeight(int weight){
        if (weight <= 0) return true;
        return false;
    }


    public <T> boolean searchName(List<Ingredient> list, String ing){
        salad = list;

        boolean ans = false;
        for (int i = 0; i < salad.size();i++){
            if (salad.get(i).getName().equals(ing)) {
                ans = true;
            }
        }
        return ans;
    }

    public <T> int searchId (List<Ingredient> list, String ing){
        salad = list;
        int  id = 0;
        for (int i = 0; i < salad.size();i++){
            if (salad.get(i).getName().equals(ing)) {
                id = i;
            }
        }
        return id;
    }

}
