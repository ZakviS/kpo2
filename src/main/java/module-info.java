module com.example.fxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires log4j;


    opens com.example.fxtest to javafx.fxml;
    exports com.example.fxtest;
}