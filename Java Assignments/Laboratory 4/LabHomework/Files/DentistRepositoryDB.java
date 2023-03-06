package LabHomework.Files;

import LabHomework.Domain.Dentist;
import LabHomework.Domain.Patient;

import java.sql.*;

public class DentistRepositoryDB extends FilesRepository<Dentist> {

    public DentistRepositoryDB(String fileName) {
        super(fileName);
    }


    @Override
    public void readFromFile() {

        String url = this.fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            String sql = "SELECT dentist_id, dentist_name, dentist_rating FROM Dentist";

            try (Statement statement  = connection.createStatement();
                 ResultSet resultSet    = statement.executeQuery(sql)){

                int i=0;
                // loop through the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("dentist_id") +  "\t" +
                            resultSet.getString("dentist_name") + "\t" +
                            resultSet.getDouble("dentist_rating"));

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
            String sql2="DELETE FROM Dentist";
            String sql = "INSERT INTO Dentist(dentist_id, dentist_name, dentist_rating) " +
                    "VALUES(?,?,?)";

            PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
            preparedStatement2.execute();

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql) ) {
                for (Dentist dentist:this.getAll()) {
                    prepareStatement.setInt(1, dentist.getId());
                    prepareStatement.setString(2, dentist.getName());
                    prepareStatement.setDouble(3, dentist.getRating());
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
