module com.example.fxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires org.apache.logging.log4j.core;
    requires org.slf4j;
    requires org.aspectj.runtime;


    opens com.example.fxtest to javafx.fxml;
    exports com.example.fxtest;
}