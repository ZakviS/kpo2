package com.example.fxtest.Service;

import com.example.fxtest.Service.VgSaladController;
import com.example.fxtest.model.Cucumber;
import com.example.fxtest.model.Ingredient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IngredientParser {


    private static final Pattern pattern = Pattern.compile("Name: (.*), calories: (.*), weight: (.*)");

    public static List<Ingredient> parseIngredientsFromString(String input) {


        List<Ingredient> ingredients = new ArrayList<>();
        VgSaladController vsc = new VgSaladController(ingredients);

        String[] lines = input.split("\n");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
//            System.out.println(line + " lien");
            if (matcher.find()) {
                String name = matcher.group(1);
//                double calories = Double.parseDouble(matcher.group(2));
                int weight = Integer.parseInt(matcher.group(3));

                // В зависимости от имени объекта вызываем соответствующий метод
                if (name.equalsIgnoreCase("Onion")) {
//                    System.out.println(weight);
                    vsc.addOnion(weight);
                } else if (name.equalsIgnoreCase("Cucumber")) {
//                    System.out.println(weight);
                    vsc.addCucumber(weight);
                } else if (name.equalsIgnoreCase("Tomato")) {
//                    System.out.println(weight);
                    vsc.addTomato(weight);
                }
            }
        }

        return vsc.getSalad();
    }


    public static void writeIngredientsToBinaryFile(List<Ingredient> ingredients, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(ingredients);
        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибок ввода/вывода
        }
    }

    public static List<Ingredient> readIngredientsFromBinaryFile(String fileName) {
        List<Ingredient> ingredients = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ingredients = (List<Ingredient>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Обработка ошибок ввода/вывода и ошибок десериализации
        }

        return ingredients;
    }

    public static void main(String[] args) {
        String input = "Name: Onion, calories: 21.6, weight: 54\n" +
                "Name: Cucumber, calories: 8.6, weight: 54\n" +
                "Name: Tomato, calories: 13.0, weight: 65";

        // Считывание данных из строки
        List<Ingredient> salad = parseIngredientsFromString(input);
//        System.out.println(salad.toString());
//        System.out.println(salad);

        // Сохранение данных в бинарный файл
        writeIngredientsToBinaryFile(salad, "ingredients.dat");

        // Чтение данных из бинарного файла
        List<Ingredient> loadedSalad = readIngredientsFromBinaryFile("ingredients.dat");
        System.out.println(loadedSalad.toString());
        // Теперь у вас есть список loadedSalad с объектами Ingredient из бинарного файла
    }
}
