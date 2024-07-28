package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        // mysql -> Database

        /*
            Code -> database
            Client -> Server


    Protocol to connect to DB
        http, https -> For web surfing
        ftp -> file transfer
        smtp -> mail transfer

        jdbc -> java database connectivity (Only for relational DBs)


        DB Server   [IP address + PORT]
        /   |   \
     DB1    DB2  DB3
    / | \
   T1 T2 T3



url : https://geeksforgeeks.org

using jdbc
url : jdbc:mysql://localhost:3306/test



 */
        String url = "jdbc:mysql://127.0.0.1:3306/test";

        // localhosy

        String sqlQuery = "CREATE TABLE person(id int, name varchar(17))";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "Ashish123@");
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Exception occured");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }






    }
}