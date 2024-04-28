package org.example;

import java.util.Scanner;

public class Accountant {

    private final Scanner scanner;
    public Accountant(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void displayAccountantMenu() {
        System.out.println("1 | Общий отчет финансовых показателей.");
        System.out.println("2 | Список сотрудников и их зарплаты.");
        System.out.println("3 | Данные продуктов.");
        System.out.println("4 | Изменение зарплаты сотрудникам.");
        System.out.println("5 | Завершить работу.");
    }

    public static void changeSalary(Scanner scanner){
        System.out.println("Введите ID сотрудника:");
        int id = scanner.nextInt();
        System.out.println("Введите новую зарплату сотрудника:");
        int newSalary = scanner.nextInt();
        CRUDUtils.updateEmployeesSalary(id, newSalary);
        System.out.println("Зарплата успешно обновлена!");
    }

    public static void showAllEmployee (){
        String query = "SELECT * FROM employee";
        CRUDUtils.getEmployeeData(query);
    }

    public static void showAllProducts (){

        CRUDUtils.getProductData();
    }

    public static void showBudget(){
        String VALUE_IN_STOCK = "SELECT SUM(quantity_in_stock * price) AS total FROM products";
        String VALUE_SOLD = "SELECT SUM(quantity_sold * price) AS total FROM products";
        System.out.println("The total price of the products in stock " + CRUDUtils.getTotalValueOfProducts(VALUE_IN_STOCK) + " som.");
        System.out.println("The total cost of the products sold " + CRUDUtils.getTotalValueOfProducts(VALUE_SOLD) + " som.");
        int sum = CRUDUtils.getTotalValueOfProducts(VALUE_IN_STOCK) + CRUDUtils.getTotalValueOfProducts(VALUE_SOLD);
        System.out.println("The total cost in general " + sum + " som.");
        System.out.println("The total price of all salaries " + CRUDUtils.getTotalSalaryValue() + " som");
    }
}
