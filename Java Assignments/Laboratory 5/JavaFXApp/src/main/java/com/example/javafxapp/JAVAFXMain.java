package com.example.javafxapp;

import com.example.Domain.Appointment;
import com.example.Domain.Dentist;
import com.example.Domain.Patient;
import com.example.Repository.AppointmentRepository;
import com.example.Repository.DentistRepository;
import com.example.Repository.PatientRepository;
import com.example.Service.AppointmentService;
import com.example.Service.DentistService;
import com.example.Service.PatientService;
import com.example.Service.ServiceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JAVAFXMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(JAVAFXMain.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("My JavaFX App");


        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}