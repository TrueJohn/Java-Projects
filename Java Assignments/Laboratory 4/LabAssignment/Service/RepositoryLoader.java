package LabAssignment.Service;

import LabAssignment.Domain.*;
import LabAssignment.Files.*;
import LabAssignment.Repository.*;
import LabAssignment.Exception.RepositoryModeException;

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

    public RepositoryLoader() {
        loadConfig(true);
    }

    public void loadConfig(boolean verbose) {
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


                default -> throw new RepositoryModeException("Invalid repository mode");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (verbose) {
            System.out.println("\nRepository settings loaded successfully: [" + repositoryMode + "]");
        }
    }

    public IRepository<Patient> initiatePatientsRepo() {
        switch (repositoryMode) {
            case "binary" -> {
                return new PatientRepositoryBinary(patientsPath);
            }

            case "csv" -> {
                return new PatientRepositoryCSV(patientsPath);
            }

            case "memory" -> {
                return new PatientRepository();
            }
            default -> throw new RepositoryModeException("Invalid repository type");
        }
    }

    public IRepository<Dentist> initiateDentistsRepo() {
        switch (repositoryMode) {
            case "binary" -> {
                return new DentistRepositoryBinary(dentistsPath);
            }
            case "csv" -> {
                return new DentistRepositoryCSV(dentistsPath);
            }
            case "memory" -> {
                return new DentistRepository();
            }
            default -> throw new RepositoryModeException("Invalid repository type");
        }
    }

    public IRepository<Appointment> initiateAppointmentsRepository() {
        switch (repositoryMode) {
            case "binary" -> {
                return new AppointmentsRepositoryBinary(appointmentsPath);
            }
            case "csv" -> {
                return new AppointmentsRepositoryCSV(appointmentsPath);
            }
            case "memory" -> {
                return new AppointmentRepository();
            }
            default -> throw new RepositoryModeException("Invalid repository type");
        }
    }
}
