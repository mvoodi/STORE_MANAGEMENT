package org.example;

import java.util.Scanner;

public class Director extends Accountant{


    public Director(Scanner scanner) {
        super(scanner);
    }

    public static void displayDirectorMenu() {
        System.out.println("1 | Найм сотрудника.");
        System.out.println("2 | Увольнение сотрудника.");
        System.out.println("3 | Показать бюджет.");
        System.out.println("4 | Показать список сотрудников.");
        System.out.println("5 | Завершить работу.");
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


}
