package com.anton;

public class employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public employee() {
    }
    public employee(int ID, String name, double salary, int age) {
        this.id = ID;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "employee{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
