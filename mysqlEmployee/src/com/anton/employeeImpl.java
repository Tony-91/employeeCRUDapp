package com.anton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class employeeImpl implements employeeInterface{

    // encapsulating and abstracting away the details of a DB-connection connection into the variable of con.
    Connection con;
    @Override
    /**
     *
     */
    public void createEmployee(employee emp) {
        // Establish a connection in each method to do-something.
        con = DBConnection.createDBConnection();

        // sql query we want to ask
        String query = "INSERT INTO employee values(?,?,?,?)";
        try (Connection con = DBConnection.createDBConnection();
             PreparedStatement pstm = con.prepareStatement(query)){
            /**
             * prepareStatement : execute parameterized SQL statements.
             * provides methods to set the values of the parameters in the SQL query, which can help prevent SQL
             * * injection attacks.
             */
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getID());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());

            int cnt = pstm.executeUpdate();
            if (cnt!=0) {
                System.out.println("Employee has been added!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employee";
        System.out.println("Employee details : ");
//        System.out.println("\n");
        System.out.println("------------------");
        System.out.format("%s\t%s\t%s\t\t\t%s\n","ID","Name","Salary","age");
        System.out.println("---------------------------------------------");
        try {
            Statement stmt = con.createStatement();

            // executeQuery(query) : Executes a SQL query and returns a ResultSet object that contains the results.
            ResultSet result = stmt.executeQuery(query);

            // while loop that exe when a change is found in result
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");
            }
            System.out.println("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployeeByID(int id) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employee WHERE id="+id;

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            /**
             * Similar while loop from showAllEmployee() : we print out a formatted employee with headers included. We
             * * grab the id number from the user and plug it into the query here.
             */
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE employee SET name=? WHERE id=?";

        try {
            /**
             * Similar to our createEmployee() method : We use prepareStatement(query) to create a query w parameters.
             * We use ` pstm.setString(1, name) ` to fill in those parameters with user input from Main.
             */
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();

            // "if pstm.executeUpdate() is successful ( returns a 1 ) then run code block."
            if (cnt!=0) {
                System.out.println("Employee details updated successfully !");
                System.out.println("---------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM employee WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);

            int cnt = pstm.executeUpdate();
            if (cnt!=0) {
                System.out.println("Employee " +id+ " deleted successfully !");
                System.out.println("---------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
