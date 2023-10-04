//package com.example.fxtest.Service;
//
//import com.example.fxtest.model.Ingredient;
//import com.example.fxtest.model.Salad;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.example.fxtest.Service.stat.*;
//
//public class MeatSaladController extends saladController{
//
//    private Salad salad;
//
//
//    public MeatSaladController(Salad salad) {
//        super(salad);
//    }
//
//    @Override
//    public double calculateCalories() {
//        return salad.calculateCalories();
//    }
//
//    @Override
//    public List<Ingredient> getIngredients() {
//        return salad.getIngredients();
//    }
//    ValidInsert vi = new ValidInsert();
//    List<Ingredient> salad = new ArrayList<Ingredient>();
//
//    public List<Ingredient> getSalad() {
//        return salad;
//    }
//
//    public void addOnion(int weight){
//        AddOnion(weight, vi, salad);
//
//    }
//
////    static void AddOnion(int weight, ValidInsert vi, ArrayList<Ingredient> salad) {
////        if (vi.searchName(salad,"Onion")){
////            salad.get(vi.searchId(salad,"Onion")).setWeight(salad.get(vi.searchId(salad,"Onion")).getWeight() + weight);
////            double call = weight *0.4;
////            salad.get(vi.searchId(salad,"Onion")).setCalories(salad.get(vi.searchId(salad,"Onion")).getCalories() + call);
////        }else {
////            Onion onion = new Onion("Onion", weight, 0.4);
////            salad.add(onion);
////        }
////    }
//
//    public void addCucumber(int weight){
//
//        AddCucumber(weight, vi, salad);
//
//    }
//
//
//    public void addTomato(int weight){
//
//        AddTomato(weight, vi, salad);
//    }
//
//    public void addChicken(int weight){
//
//        AddChicken(weight, vi, salad);
//    }
//
//    public void addTurkey(int weight){
//
//        AddTurkey(weight, vi, salad);
//    }
//
//}
