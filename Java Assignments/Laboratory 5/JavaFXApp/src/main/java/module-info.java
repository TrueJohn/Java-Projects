module com.example.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.junit.jupiter.api;
    requires java.sql;

    opens com.example.javafxapp to javafx.fxml;
    exports com.example.javafxapp;
}