package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.sql.*;

public class PatientsDataAccessService {

    //TODO : do not throw exception
    public PatientsDataAccessService() throws Exception {
        //TODO: make this configurable
        Connection connection = getConnection();


        String createTable = """
            CREATE TABLE IF NOT EXISTS patients ( 
                    patNumHC VARCHAR(255) PRIMARY KEY,
                    lastName VARCHAR(255) NOT NULL,
                    firstName VARCHAR(255) NOT NULL,
                    address VARCHAR(255) NOT NULL)
        """;

        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();

    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String userName = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    public void createPatient(Patient patient) throws SQLException {
        Connection connection = getConnection();
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO PATIENTS(patNumHC, lastName, firstName, address) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, patient.getPatNumHC());
        preparedStatement.setString(2, patient.getLastName());
        preparedStatement.setString(3, patient.getFirstName());
        preparedStatement.setString(4, patient.getAddress());
        preparedStatement.execute();
    }

    public void updatePatient(Patient patient) {

    }

    public void deletePatient(Patient patient) {

    }


}
