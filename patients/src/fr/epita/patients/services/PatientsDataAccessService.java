package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;
import fr.epita.patients.exceptions.PatientCreationException;
import fr.epita.patients.exceptions.PatientSearchException;
import fr.epita.patients.exceptions.PatientUpdateException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void createPatient(Patient patient) throws PatientCreationException {
        try(Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO PATIENTS(patNumHC, lastName, firstName, address) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, patient.getPatNumHC());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getFirstName());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new PatientCreationException("unable to create patient", e);
        }
    }

    public void updatePatient(Patient patient) throws PatientUpdateException {
        String updateQuery = "UPDATE PATIENTS SET lastName = ? WHERE patNumHC = ?";

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, patient.getLastName());
            preparedStatement.setString(2, patient.getPatNumHC());
            preparedStatement.execute();
        }catch (SQLException e) {
            throw new PatientUpdateException("unable to update patient with id: " + patient.getPatNumHC(), e);
        }
    }

    public void deletePatient(Patient patient) {

    }

    public Patient getPatient(String patNumHC) {
        return null;
    }

    public List<Patient> searchPatients(Patient patientExample) throws PatientSearchException {
        List<Patient> patients = new ArrayList<>();
        String patientSearchquery = """
        SELECT * FROM PATIENTS WHERE 
                                (? IS NULL OR patNumHC = ?) AND 
                                (? IS NULL OR lastName LIKE ?) AND 
                                (? IS NULL OR firstName = ?) AND 
                                (? IS NULL OR address = ?)
        """;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(patientSearchquery);
            preparedStatement.setString(1, patientExample.getPatNumHC());
            preparedStatement.setString(2, patientExample.getPatNumHC());
            preparedStatement.setString(3, patientExample.getLastName());
            preparedStatement.setString(4, patientExample.getLastName() + "%");
            preparedStatement.setString(5, patientExample.getFirstName());
            preparedStatement.setString(6, patientExample.getFirstName());
            preparedStatement.setString(7, patientExample.getAddress());
            preparedStatement.setString(8, patientExample.getAddress());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patient patient = new Patient(  resultSet.getString("patNumHC"),
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getString("address"),
                        null, null, null
                        );

                patients.add(patient);


                ;
            }
        }catch (SQLException e){
            //TODO create it properly
            throw new PatientSearchException();
        }
        return patients;

    }


}
