package fr.epita.patients.tests;

import java.sql.*;

public class TestDB {


    public static void main(String[] args) throws Exception {
        // db url
         // username
         // password
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String userName = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, userName, password);


        String testQuery = testCreateTable(connection);

       // testInsert(connection, testQuery);
        testDelete(connection, testQuery);


    }

    private static String testCreateTable(Connection connection) throws SQLException {

        String createTable = """
            CREATE TABLE IF NOT EXISTS patients ( 
                    patNumHC VARCHAR(255) PRIMARY KEY,
                    lastName VARCHAR(255) NOT NULL,
                    firstName VARCHAR(255) NOT NULL,
                    address VARCHAR(255) NOT NULL)
        """;

        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
        String testQuery = "select * from patients";
        ResultSet resultSet = connection.prepareStatement(testQuery).executeQuery();
        if (resultSet != null) {
            System.out.println("test successful");
        }
        return testQuery;
    }

    private static void testInsert(Connection connection, String testQuery) throws SQLException {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO PATIENTS(patNumHC, lastName, firstName, address) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "1234");
        preparedStatement.setString(2, "BOB");
        preparedStatement.setString(3, "John");
        preparedStatement.setString(4, "Paris");

        preparedStatement.execute();

        resultSet = connection.prepareStatement(testQuery).executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("patNumHC"));
            if (resultSet.getString("patNumHC").equals("1234")) {
                System.out.println("test successful");
            }
        }
        connection.prepareStatement("TRUNCATE TABLE PATIENTS").execute();
    }

    private static void testUpdate(Connection connection, String testQuery) throws SQLException {
       //given
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO PATIENTS(patNumHC, lastName, firstName, address) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "1234");
        preparedStatement.setString(2, "BOB");
        preparedStatement.setString(3, "John");
        preparedStatement.setString(4, "Paris");
        preparedStatement.execute();

        //when
        String updateQuery = "UPDATE PATIENTS SET lastName = ? WHERE patNumHC = ?";
        preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, "Johnny");
        preparedStatement.setString(2, "1234");
        preparedStatement.execute();

        resultSet = connection.prepareStatement(testQuery).executeQuery();
        //then
        while (resultSet.next()) {
            System.out.println(resultSet.getString("patNumHC"));
            if (resultSet.getString("firstName").equals("Johnny")) {
                System.out.println("test successful");
                System.out.println(resultSet.getString("firstName"));
            }
        }

        connection.prepareStatement("TRUNCATE TABLE PATIENTS").execute();
    }
    private static void testDelete(Connection connection, String testQuery) throws SQLException {
       //given
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO PATIENTS(patNumHC, lastName, firstName, address) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "1234");
        preparedStatement.setString(2, "BOB");
        preparedStatement.setString(3, "John");
        preparedStatement.setString(4, "Paris");
        preparedStatement.execute();

        //when
        String updateQuery = "DELETE FROM PATIENTS WHERE patNumHC = ?";
        preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, "1234");
        preparedStatement.execute();

        resultSet = connection.prepareStatement(testQuery).executeQuery();
        //then
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        if (count == 0){
            System.out.println("test successful");
        }
        connection.prepareStatement("TRUNCATE TABLE PATIENTS").execute();
    }
}
