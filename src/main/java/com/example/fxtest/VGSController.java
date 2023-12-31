package com.example.fxtest;


import com.example.fxtest.Service.VgSaladController;
import com.example.fxtest.model.CaloriesCounterDecorator;
import com.example.fxtest.model.Ingredient;
import com.example.fxtest.model.Salad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.fxtest.Service.IngredientParser.*;

public class VGSController {

    private static final Logger log = LoggerFactory.getLogger(VGSController.class);
    @FXML
    private Button onHelloButtonClick;
    @FXML
    private Button AddOnionButtonClick;
    @FXML
    private Button addTomatoButtonClick;
    @FXML
    private Button addCucumberButtonClick;
    @FXML
    private Button saveSaladButtonClick;
    @FXML
    private Button readFileButtonClick;
    @FXML
    private Button saveBinarSaladButtonClick;
    @FXML
    private Button readBinarFileButtonClick;
    @FXML
    private void initialize() {
//        ResourceBundle.Control control = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
        Locale russianLocale = new Locale("ru", "RU");
        Locale englishLocale = new Locale("en", "En");

//        ResourceBundle bundle = ResourceBundle.getBundle("messages", russianLocale);
        ResourceBundle bundle = ResourceBundle.getBundle("messages", englishLocale);

        onHelloButtonClick.setText(bundle.getString("button.createSalad"));
        AddOnionButtonClick.setText(bundle.getString("button.addOnion"));
        addTomatoButtonClick.setText(bundle.getString("button.addTomato"));
        addCucumberButtonClick.setText(bundle.getString("button.addCucumber"));
        saveSaladButtonClick.setText(bundle.getString("button.saveToFile"));
        readFileButtonClick.setText(bundle.getString("button.openFile"));
        saveBinarSaladButtonClick.setText(bundle.getString("button.saveToBinaryFile"));
        readBinarFileButtonClick.setText(bundle.getString("button.openBinaryFile"));}

    List<Ingredient> ingredients = new ArrayList<>(); // Получите список ингредиентов

    // Создайте салат
    Salad salad = new VgSaladController(ingredients);

    // Декорируйте салат с функциональностью подсчета калорий
    Salad decoratedSalad = new CaloriesCounterDecorator(salad);

    // Вызовите метод calculateCalories() для подсчета калорий
    VgSaladController vsc = new VgSaladController(ingredients);


    private static final Pattern pattern = Pattern.compile("Name: (.*), calories: (.*), weight: (.*)");
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText(salad());
    }

    public String salad(){
        log.info("Это информационное сообщение!");
        vsc = new VgSaladController(ingredients);

        Random random = new Random();
        int weight;

        weight = random.nextInt(200);
        vsc.addOnion(weight);

        weight = random.nextInt(200);
        vsc.addCucumber(weight);

        weight = random.nextInt(200);
        vsc.addTomato(weight);
        System.out.println(decoratedSalad.calculateCalories());
        log.info("Это выведен салат: " + vsc.getSalad());
        return vsc.printInfoString(vsc.getSalad());

    }

    @FXML
    protected void addCucumberButtonClick() {
        Stage inputStage = new Stage();
        Button saveButton = new Button("Сохранить");


        inputStage.setTitle("Добавить огурец");

        // Создайте интерфейс ввода текста, например, TextField
        TextField textField = new TextField();

        saveButton.setOnAction(event -> {
            String enteredText = textField.getText(); // Получите текст из поля ввода
            vsc.addCucumber(Integer.parseInt(enteredText.trim()));
            welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
            ((Stage) saveButton.getScene().getWindow()).close();
            // Например, в переменную класса или в другое место по вашему усмотрению
        });


        // Добавьте элементы интерфейса на окно и определите их макет
        VBox layout = new VBox(10); // Пример макета VBox
//        layout.getChildren().add(textField);
        layout.getChildren().addAll(textField, saveButton); // Добавьте кнопку на макет

        // Создайте сцену для нового окна
        Scene inputScene = new Scene(layout, 300, 70);

        // Установите сцену для нового окна
        inputStage.setScene(inputScene);

        // Покажите новое окно
        inputStage.show();

    }
    @FXML
    protected void addTomatoButtonClick() {
        Stage inputStage = new Stage();
        Button saveButton = new Button("Сохранить");


        inputStage.setTitle("Добавить помидор");

        // Создайте интерфейс ввода текста, например, TextField
        TextField textField = new TextField();

        saveButton.setOnAction(event -> {
            String enteredText = textField.getText(); // Получите текст из поля ввода
            vsc.addTomato(Integer.parseInt(enteredText.trim()));
            welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
            ((Stage) saveButton.getScene().getWindow()).close();
            // Например, в переменную класса или в другое место по вашему усмотрению
        });


        // Добавьте элементы интерфейса на окно и определите их макет
        VBox layout = new VBox(10); // Пример макета VBox
//        layout.getChildren().add(textField);
        layout.getChildren().addAll(textField, saveButton); // Добавьте кнопку на макет

        // Создайте сцену для нового окна
        Scene inputScene = new Scene(layout, 300, 70);

        // Установите сцену для нового окна
        inputStage.setScene(inputScene);

        // Покажите новое окно
        inputStage.show();
//        return vsc.printInfoString(vsc.getSalad());



    }
    @FXML
    protected void AddOnionButtonClick() {
        Stage inputStage = new Stage();
        Button saveButton = new Button("Сохранить");


        inputStage.setTitle("Добавить лук");

        // Создайте интерфейс ввода текста, например, TextField
        TextField textField = new TextField();

        saveButton.setOnAction(event -> {
            String enteredText = textField.getText(); // Получите текст из поля ввода
            vsc.addOnion(Integer.parseInt(enteredText.trim()));
            welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
            ((Stage) saveButton.getScene().getWindow()).close();
            // Например, в переменную класса или в другое место по вашему усмотрению
        });


        // Добавьте элементы интерфейса на окно и определите их макет
        VBox layout = new VBox(10); // Пример макета VBox
//        layout.getChildren().add(textField);
        layout.getChildren().addAll(textField, saveButton); // Добавьте кнопку на макет

        // Создайте сцену для нового окна
        Scene inputScene = new Scene(layout, 300, 70);

        // Установите сцену для нового окна
        inputStage.setScene(inputScene);

        // Покажите новое окно
        inputStage.show();
//        return vsc.printInfoString(vsc.getSalad());


    }

    @FXML
    protected void saveSaladButtonClick() {
        Stage inputStage = new Stage();
        Button saveButton = new Button("Ок");


        inputStage.setTitle("файл сохранен");

        // Создайте интерфейс ввода текста, например, TextField

        saveButton.setOnAction(event -> {
            welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
            ((Stage) saveButton.getScene().getWindow()).close();
            // Например, в переменную класса или в другое место по вашему усмотрению
        });


        // Добавьте элементы интерфейса на окно и определите их макет
        VBox layout = new VBox(10); // Пример макета VBox
//        layout.getChildren().add(textField);
        layout.getChildren().addAll( saveButton); // Добавьте кнопку на макет

        // Создайте сцену для нового окна
        Scene inputScene = new Scene(layout, 300, 70);

        // Установите сцену для нового окна
        inputStage.setScene(inputScene);

        // Покажите новое окно
        inputStage.show();
//        return vsc.printInfoString(vsc.getSalad());

        String infoString = vsc.printInfoString(vsc.getSalad());
        vsc.saveInfoStringToFile(infoString, "output.txt");


    }
    @FXML
    protected void readFileButtonClick() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Выбор и чтение файла");

        // Создаем кнопку для выбора файла
        Button chooseFileButton = new Button("Выбрать файл");
        chooseFileButton.setOnAction(e -> openAndReadFile(primaryStage));

        // Создаем макет и добавляем кнопку
        VBox vBox = new VBox();
        vBox.getChildren().add(chooseFileButton);

        Scene scene = new Scene(vBox, 300, 70);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @FXML
    protected void saveBinarSaladButtonClick() {
        Stage inputStage = new Stage();
        Button saveButton = new Button("Ок");


        inputStage.setTitle("файл сохранен");

        // Создайте интерфейс ввода текста, например, TextField

        saveButton.setOnAction(event -> {
            welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
            ((Stage) saveButton.getScene().getWindow()).close();
            // Например, в переменную класса или в другое место по вашему усмотрению
        });


        // Добавьте элементы интерфейса на окно и определите их макет
        VBox layout = new VBox(10); // Пример макета VBox
//        layout.getChildren().add(textField);
        layout.getChildren().addAll( saveButton); // Добавьте кнопку на макет

        // Создайте сцену для нового окна
        Scene inputScene = new Scene(layout, 300, 70);

        // Установите сцену для нового окна
        inputStage.setScene(inputScene);

        // Покажите новое окно
        inputStage.show();

        String infoString = vsc.printInfoString(vsc.getSalad());
//        vsc.saveInfoStringToFile(infoString, "output.txt");
        System.out.println(infoString);
        List<Ingredient> salad = parseIngredientsFromString(infoString);
        writeIngredientsToBinaryFile(salad, "ingredients.dat");
        log.info("Салат сохранен в бинарный файл:" + salad.toString());

    }
    @FXML
    protected void readBinarFileButtonClick() {
//        Stage primaryStage = new Stage();
        List<Ingredient> loadedSalad = readIngredientsFromBinaryFile("ingredients.dat");
        welcomeText.setText(loadedSalad.toString());
        log.info("Салат из бинарного файла:" + loadedSalad.toString());


    }

    private void openAndReadFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");

        // Открываем диалоговое окно выбора файла
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            String fileContent = vsc.readFile((selectedFile));
            parseIngredientsFromFile(fileContent);
            log.info("Салат взят из файла: " + fileContent);

        } else {
            log.error("Файл не выбран." );
            System.out.println("Файл не выбран.");
        }
    }

    public void parseIngredientsFromFile(String input) {
        try {
            String[] lines = input.split("\n");
            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    int weight = Integer.parseInt(matcher.group(3));

                    // В зависимости от имени объекта вызываем соответствующий метод
                    if (name.equalsIgnoreCase("Onion")) {
                        vsc.addOnion(weight);
                    }
                    if (name.equalsIgnoreCase("Cucumber")) {
                        vsc.addCucumber(weight);
                    }
                    if (name.equalsIgnoreCase("Tomato")) {
                        vsc.addTomato(weight);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            // Обработка ошибок ввода/вывода
        }
        welcomeText.setText(vsc.printInfoString(vsc.getSalad()));
    }

}