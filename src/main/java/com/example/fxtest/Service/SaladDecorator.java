package com.example.fxtest.Service;
import com.example.fxtest.model.Ingredient;
import com.example.fxtest.model.Salad;

import java.util.List;

public abstract class SaladDecorator implements Salad {
    private Salad salad;

    public SaladDecorator(Salad salad) {
        this.salad = salad;
    }

    @Override
    public double calculateCalories() {
        return salad.calculateCalories();
    }

    @Override
    public List<Ingredient> getIngredients() {
        return salad.getIngredients();
    }
}
