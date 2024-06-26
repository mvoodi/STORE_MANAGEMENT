package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        Scanner warehouseScanner = new Scanner(System.in);
        Scanner directorScanner = new Scanner(System.in);
        String directorLogin = "director";
        String directorPassword = "director123";

        String sellerLogin = "seller";
        String sellerPassword = "seller123";

        String accountantLogin = "accountant";
        String accountantPassword = "123456";

        String warehouseManagerLogin = "warehouse";
        String warehouseManagerPassword = "warehouse123";
        boolean working = true;
        boolean islogged = false;

        while(!islogged){
            System.out.println("Введите логин:");
            String login = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            if (login.equals(directorLogin) && password.equals(directorPassword)) {
                islogged = true;
                while (working) {
                    Director.displayDirectorMenu();
                    int directorChoice = intScanner.nextInt();

                    if (directorChoice == 2) {
                        Director.removeEmployee(intScanner);
                    } else if (directorChoice == 1) {
                        Director.addEmployee(directorScanner, intScanner);
                    } else if (directorChoice == 3) {
                        Director.showBudget();
                    } else if (directorChoice == 4) {
                        Director.showAllEmployee();
                    } else if (directorChoice == 5) {
                        System.out.println("Работа завершена.");
                        working = false;
                        break;
                    } else {
                        System.out.println("Неверная команда. Введите еще раз.");
                    }

                }
            } else if (login.equals(sellerLogin) && password.equals(sellerPassword)) {
                islogged = true;
                while (working) {
                    Seller.displaySellerMenu();
                    int sellerChoice = intScanner.nextInt();

                    if (sellerChoice == 1) {
                        Seller.sellProduct(intScanner);
                    } else if (sellerChoice == 2) {
                        System.out.println("The work is completed.");
                        working = false;
                        break;
                    } else {
                        System.out.println("Неверная команда. Введите еще раз.");
                    }
                }
            } else if (login.equals(accountantLogin) && password.equals(accountantPassword)) {
                while (working) {
                    islogged = true;
                    Accountant.displayAccountantMenu();
                    int accountantChoice = intScanner.nextInt();

                    if (accountantChoice == 1) {
                        Accountant.showBudget();
                    } else if (accountantChoice == 2) {
                        Accountant.showAllEmployee();
                    } else if (accountantChoice == 3) {
                        Accountant.showAllProducts();
                    } else if (accountantChoice == 4) {
                        Accountant.changeSalary(intScanner);
                    } else if (accountantChoice == 5) {
                        System.out.println("Работа завершена.");
                        working = false;
                        break;
                    } else {
                        System.out.println("Неверная команда. Введите еще раз.");
                    }
                }
            } else if (login.equals(warehouseManagerLogin) && password.equals(warehouseManagerPassword)) {
                while (working) {
                    islogged = true;
                    WarehouseManager.displayWarehouseManagerMenu();
                    int warehouseManagerChoice = intScanner.nextInt();
                    if (warehouseManagerChoice == 1) {
                        System.out.println("1 | Прием товаров");
                        System.out.println("2 | Отгрузка товаров");
                        int warehouseSecondChoice = scanner.nextInt();
                        if (warehouseSecondChoice == 1) {
                            WarehouseManager.ProductsAcceptance(intScanner);
                        } else if (warehouseSecondChoice == 2) {
                            WarehouseManager.ProductsShipment(intScanner);
                        } else {
                            System.out.println("Ошибка! Такой команды не существует!");
                        }
                    } else if (warehouseManagerChoice == 2) {
                        WarehouseManager.updateProductPrice(intScanner);
                    } else if (warehouseManagerChoice == 3) {
                        WarehouseManager.showAllProducts();
                    } else if (warehouseManagerChoice == 4) {
                        WarehouseManager.addNewProduct(warehouseScanner, intScanner);
                    } else if (warehouseManagerChoice == 5) {
                        WarehouseManager.removeProduct(intScanner);
                    } else if (warehouseManagerChoice == 6) {
                        System.out.println("Работа завершена.");
                        working = false;
                        break;
                    } else {
                        System.out.println("Неверная команда. Введите еще раз.");
                    }

                }


            }
            else{
                System.out.println("Неправильный логин или пароль.");
            }

        }



    }
}
