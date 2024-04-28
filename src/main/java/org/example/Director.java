package org.example;

import java.util.Scanner;

public class Director{

    private final Scanner scanner;
    public Director(Scanner scanner) {
        this.scanner = scanner;
    }
    public static void displayDirectorMenu() {
        System.out.println("1 | Найм сотрудника.");
        System.out.println("2 | Увольнение сотрудника.");
        System.out.println("3 | Показать бюджет.");
        System.out.println("4 | Показать список сотрудников.");
    }

    public static void removeEmployee(Scanner scanner) {
        System.out.println("Введите ID работника которого хотите уволить.");
        int employeeID = scanner.nextInt();
        String deleteQuery = "DELETE FROM employee WHERE id = ?";
        CRUDUtils.deleteEmployee(deleteQuery, employeeID);
    }

    public static void addEmployee(Scanner scanner){
        System.out.println("Введите имя нового сотрудника:");

        String name = scanner.nextLine();
        System.out.println("Введите фамилию нового сотрудника:");
        String surname = scanner.nextLine();
        System.out.println("Введите должность нового сотрудника:");
        String post = scanner.nextLine();
        System.out.println("Введите зарплату нового сотрудника:");
        int salary = scanner.nextInt();

        scanner.nextInt();


        String INSERT_EMPLOYEE = "INSERT INTO employee (name, surname, post, salary) VALUES (?, ?, ?, ?)";
        CRUDUtils.saveEmployeeData(INSERT_EMPLOYEE, name, surname, post, salary);
    }

    public static void showBudget(){
        String VALUE_IN_STOCK = "SELECT SUM(quantity_in_stock * price) AS total FROM products";
        String VALUE_SOLD = "SELECT SUM(quantity_sold * price) AS total FROM products";
        System.out.println("The total price of the goods in stock " + CRUDUtils.getTotalValueOfProducts(VALUE_IN_STOCK) + " som.");
        System.out.println("The total cost of the goods sold " + CRUDUtils.getTotalValueOfProducts(VALUE_SOLD) + " som.");
        int sum = CRUDUtils.getTotalValueOfProducts(VALUE_IN_STOCK) + CRUDUtils.getTotalValueOfProducts(VALUE_SOLD);
        System.out.println("The total cost in general " + sum + " som.");
    }

    public static void showAllEmployee (){
        String query = "SELECT * FROM employee";
        CRUDUtils.getEmployeeData(query);
    }
}
