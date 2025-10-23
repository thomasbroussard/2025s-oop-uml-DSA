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


    }
}
