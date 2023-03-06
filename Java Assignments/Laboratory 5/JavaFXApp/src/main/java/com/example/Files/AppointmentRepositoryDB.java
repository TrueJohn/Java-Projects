package com.example.Files;

import com.example.Domain.Appointment;
import com.example.Domain.Dentist;

import java.sql.*;

public class AppointmentRepositoryDB extends FilesRepository<Appointment> {
    public AppointmentRepositoryDB(String fileName) {
        super(fileName);
    }


    @Override
    public void readFromFile() {

        String url = this.fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT appointment_id, appointment_details, appointment_date, appointment_duration, dentist_id, patient_id FROM Appointments";

            try (Statement statement  = connection.createStatement();
                 ResultSet resultSet    = statement.executeQuery(sql)){

                int i=0;
                // loop through the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("appointment_id") +  "\t" +
                            resultSet.getString("appointment_details") + "\t" +
                            resultSet.getString("appointment_date") + "\t" +
                            resultSet.getInt("appointment_duration") + "\t" +
                            resultSet.getInt("dentist_id") + "\t" +
                            resultSet.getInt("patient_id") + "\t" +
                            resultSet.getString("appointment_date"));

                    System.out.println("Row:"+i+"--------------------------");
                    i++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }

    @Override
    public void writeToFile() {
        String url = this.fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql2="DELETE FROM Appointments";
            String sql = "INSERT INTO Appointments(appointment_id, appointment_details, appointment_date, appointment_duration, dentist_id, patient_id) " +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
            preparedStatement2.execute();

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql) ) {
                for (Appointment appointment:this.getAll()) {
                    prepareStatement.setInt(1, appointment.getId());
                    prepareStatement.setString(2, appointment.getDetails());
                    prepareStatement.setString(3, appointment.getDate());
                    prepareStatement.setInt(4, appointment.getDuration());
                    prepareStatement.setInt(5, appointment.getDentist().getId());
                    prepareStatement.setInt(6, appointment.getPatient().getId());

                    prepareStatement.executeUpdate();

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
