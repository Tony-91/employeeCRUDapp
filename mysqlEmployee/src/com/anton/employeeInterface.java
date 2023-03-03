package com.anton;

public interface employeeInterface {

    // create employee
    public void createEmployee(employee emp);
    // show employees
    public void showAllEmployee();
    // show employee by ID
    public void showAllEmployeeByID(int id);
    // update employee
    public void updateEmployee(int id, String name);
    // delete employee
    public void deleteEmployee(int id);

}
