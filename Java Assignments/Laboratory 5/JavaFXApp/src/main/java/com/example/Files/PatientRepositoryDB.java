package com.example.Files;

import com.example.Domain.Patient;


import java.sql.*;



public class PatientRepositoryDB  extends FilesRepository<Patient>{

    public PatientRepositoryDB(String fileName) {
        super(fileName);
    }


    @Override
    public void readFromFile() {

        String url = this.fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT patient_id, patient_name, patient_age,patient_phone_number,patient_identification_number FROM Patient";

            try (Statement statement  = connection.createStatement();
                 ResultSet resultSet    = statement.executeQuery(sql)){

                int i=0;
                // loop through the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("patient_id") +  "\t" +
                            resultSet.getString("patient_name") + "\t" +
                            resultSet.getInt("patient_age") + "\t" +
                            resultSet.getString("patient_phone_number") + "\t" +
                            resultSet.getString("patient_identification_number"));

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
            String sql2="DELETE FROM Patient";
            String sql = "INSERT INTO Patient(patient_id,patient_name,patient_age,patient_phone_number,patient_identification_number) " +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
            preparedStatement2.execute();

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql) ) {
                for (Patient patient:this.getAll()) {
                    prepareStatement.setInt(1, patient.getId());
                    prepareStatement.setString(2, patient.getName());
                    prepareStatement.setInt(3, patient.getAge());
                    prepareStatement.setString(4, patient.getPhoneNumber());
                    prepareStatement.setString(5, patient.getPersonalIdentificationCode());
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

