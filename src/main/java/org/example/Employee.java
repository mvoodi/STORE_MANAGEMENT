package org.example;

public class Employee {
    int id;
    String name;
    String surname;
    String post;
    int salary;

    @Override
    public String toString() {
        String format = "| %-4s | %-15s | %-15s | %-15s | %-10s |%n";
        StringBuilder sb = new StringBuilder();
        sb.append("+------+-----------------+-----------------+-----------------+------------+%n");
        sb.append("| ID   | Name            | Surname         | Post            | Salary     |%n");
        sb.append("+------+-----------------+-----------------+-----------------+------------+%n");
        sb.append(String.format(format, id, name, surname, post, salary));
        sb.append("+------+-----------------+-----------------+-----------------+------------+%n");
        return sb.toString();
    }

    public  Employee(){

    }
    public Employee(int id, String name, String surname, String post, int salary){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


