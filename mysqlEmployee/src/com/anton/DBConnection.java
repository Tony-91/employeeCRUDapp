package com.anton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
/**
 * Steps to connect into mysql database:
 * S1 : Integrate .tar file into dependency.
 * S2 : Create BDConnection try/catch method - load driver & create connection.
 */

    static  Connection con;
    public static Connection createDBConnection() {

        try {
            // load driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
            // get connection
            String url = "jdbc:mysql://localhost:3306/employeeDB";
            String username = "root";
            String password = "Element1991";
            con = DriverManager.getConnection(url,username,password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return con;

    }



}
