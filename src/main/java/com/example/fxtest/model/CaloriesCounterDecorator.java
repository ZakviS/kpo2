package com.example.fxtest.model;

import com.example.fxtest.Service.SaladDecorator;
import com.example.fxtest.Service.VgSaladController;

public class CaloriesCounterDecorator extends SaladDecorator {
    public CaloriesCounterDecorator(Salad salad) {
        super(salad);
    }

    @Override
    public double calculateCalories() {
        double calories = super.calculateCalories();
        System.out.println("Общая сумма калорий в салате: " + calories);
        return calories;
    }
}
