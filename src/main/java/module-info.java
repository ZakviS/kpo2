module com.example.fxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.fxtest to javafx.fxml;
    exports com.example.fxtest;
}