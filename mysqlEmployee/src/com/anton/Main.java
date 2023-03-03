package com.anton;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        employeeInterface empObj = new employeeImpl();
        System.out.println("Welcome to employee management application.");
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                    1. Add Employee
                    2. Show All Employee
                    3. Show Employee based on id\s
                    4. Update the employee
                    5. Delete the employee
                    """);

            System.out.println("Enter Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    employee emp = new employee();
                    // retrieve employee info from user...

                    System.out.println("Enter ID : ");
                    id = sc.nextInt();
                    System.out.println("Enter name : ");
                    name = sc.next();
                    System.out.println("Enter Salary : ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter age : ");
                    int age = sc.nextInt();
                    // ...SET employee details by plugging in params.
                    emp.setID(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    empObj.createEmployee(emp);
                    break;
                case 2:
                    empObj.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID for details.");
                    int empid = sc.nextInt();
                    empObj.showAllEmployeeByID(empid);
                    break;
                case 4:
                    System.out.println("Enter ID to update details");
                    int empid2 = sc.nextInt();
                    System.out.println("Enter the new name");
                    name = sc.next();
                    empObj.updateEmployee(empid2,name);
                    break;
                case 5:
                    System.out.println("Enter ID to delete.");
                    id = sc.nextInt();
                    empObj.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you.");
                    System.exit(0);
                default:
                    System.out.println("Please enter valid choice.");
                    break;

            }
        } while (true);
    }
}