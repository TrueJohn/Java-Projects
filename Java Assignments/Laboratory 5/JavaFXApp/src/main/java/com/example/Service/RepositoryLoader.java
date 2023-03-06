package com.example.Service;

import com.example.Domain.Appointment;
import com.example.Domain.Dentist;
import com.example.Domain.Patient;
import com.example.Exception.RepositoryModeException;
import com.example.Files.*;
import com.example.Repository.AppointmentRepository;
import com.example.Repository.DentistRepository;
import com.example.Repository.IRepository;
import com.example.Repository.PatientRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

final public class RepositoryLoader {
    private static final String SETTINGS_FILE = "LabHomework/Settings/settings.properties";
    private static final String PATHS_FILE = "LabHomework/Settings/file.paths";
    private String repositoryMode;
    private String dentistsPath;
    private String patientsPath;
    private String appointmentsPath;

    public String getRepositoryMode() {
        return repositoryMode;
    }

    public String getDentistsPath() {
        return dentistsPath;
    }

    public String getPatientsPath() {
        return patientsPath;
    }

    public String getAppointmentsPath() {
        return appointmentsPath;
    }

    public void loadConfig() {
        Properties properties = new Properties();
        try (InputStream pf = new FileInputStream(SETTINGS_FILE)) {
            properties.load(pf);
            repositoryMode = properties.getProperty("RepositoryMode");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream pf = new FileInputStream(PATHS_FILE)) {
            properties.load(pf);
            switch (repositoryMode) {
                case "binary" -> {
                    dentistsPath = properties.getProperty("DentistsBinary");
                    patientsPath = properties.getProperty("PatientsBinary");
                    appointmentsPath = properties.getProperty("AppointmentsBinary");
                }

                case "csv" -> {
                    dentistsPath = properties.getProperty("DentistsCSV");
                    patientsPath = properties.getProperty("PatientsCSV");
                    appointmentsPath = properties.getProperty("AppointmentsCSV");
                }

                case "memory" -> {
                    dentistsPath = null;
                    patientsPath = null;
                    appointmentsPath = null;
                }
                case "database" -> {

                }

                case "json" -> {
                    dentistsPath = properties.getProperty("DentistsJSON");
                    patientsPath = properties.getProperty("PatientsJSON");
                    appointmentsPath = properties.getProperty("AppointmentsJSON");

                }

                case "xml" -> {
                    dentistsPath = properties.getProperty("DentistsXML");
                    patientsPath = properties.getProperty("PatientsXML");
                    appointmentsPath = properties.getProperty("AppointmentsXML");

                }


                default -> throw new RepositoryModeException("Invalid repository mode");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
