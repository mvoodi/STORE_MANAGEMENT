package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Scanner directorScanner = new Scanner(System.in);
        String directorLogin = "director";
        String directorPassword = "director123";

        String sellerLogin = "seller";
        String sellerPassword = "seller123";

        String accountantLogin = "accountant";
        String accountantPassword = "123456";
        boolean working = true;


        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        if(login.equals(directorLogin) && password.equals(directorPassword)){
            while(working){
                Director.displayDirectorMenu();
                int directorChoice = scanner.nextInt();

                if(directorChoice == 2){
                    Director.removeEmployee(directorScanner);
                }
                else if(directorChoice == 1){
                    Director.addEmployee(directorScanner);
                }
                else if(directorChoice == 3){
                    Director.showBudget();
                }
                else if(directorChoice == 4){
                    Director.showAllEmployee();
                }
                else if(directorChoice == 5){
                    System.out.println("The work is completed.");
                    working = false;
                    break;
                }
                else{
                    System.out.println("Неверная команда. Введите еще раз.");
                }
            }
        }
        else if(login.equals(sellerLogin) && password.equals(sellerPassword)){
            while(working){
                Seller.displaySellerMenu();
                int sellerChoice = scanner.nextInt();

                if(sellerChoice == 1){
                    Seller.sellProduct(scanner);
                }
                else if(sellerChoice == 2){
                    System.out.println("The work is completed.");
                    working = false;
                    break;
                }
                else{
                    System.out.println("Неверная команда. Введите еще раз.");
                }
            }
        }
        else if(login.equals(accountantLogin) && password.equals(accountantPassword)){
            while(working){
                Accountant.displayAccountantMenu();
                int accountantChoice = scanner.nextInt();

                if(accountantChoice == 1){
                    Accountant.showBudget();
                }
                else if(accountantChoice == 2){
                    Accountant.showAllEmployee();
                }
                else if(accountantChoice == 3){
                    Accountant.showAllProducts();
                }
                else if(accountantChoice == 4){
                    Accountant.changeSalary(scanner);
                }
                else if(accountantChoice == 5){
                    System.out.println("Работа завершена.");
                    working = false;
                    break;
                }
                else{
                    System.out.println("Неверная команда. Введите еще раз.");
                }
            }
        }



//        String INSERT_PRODUCT = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
//        String updateQuery = "UPDATE products SET price = ? WHERE id = ?";
//        String updateQuantityQuery = "UPDATE products SET quantity = ? WHERE id = ?";
//
//
//        System.out.println("Введите название продукта:");
//        String name = scanner.nextLine();
//
//        System.out.println("Введите цену продукта:");
//        int price = scanner.nextInt();
//
//        System.out.println("Введите количество продукта:");
//        int quantity = scanner.nextInt();
//
//
//
//        CRUDUtils.saveProductData(INSERT_PRODUCT, name, price, quantity);
//
//
//
//        System.out.println("Введите идентификатор товара:");
//        int productId = scanner.nextInt();
//
//        System.out.println("Введите новую цену товара:");
//        int newPrice = scanner.nextInt();
//
//        CRUDUtils.updateProductPrice(updateQuery, newPrice, productId);
//
//
//        System.out.println("Введите идентификатор товара, который вы хотите изменить:");
//        int productId1 = scanner.nextInt();
//
//        System.out.println("Введите новое количество товара:");
//        int newQuantity = scanner.nextInt();
//
//        String updateQuery1 = "UPDATE products SET quantity = ? WHERE id = ?";
//
//        CRUDUtils.updateProductQuantity(updateQuantityQuery, productId1, newQuantity);
//
//        System.out.println("Введите ID товара, который вы хотите удалить:");
//        int productId2 = scanner.nextInt();
//        String deleteQuery = "DELETE FROM products WHERE id = ?";
//        CRUDUtils.deleteProduct(deleteQuery, productId2);
//
//
//
//
//
//        List<Product> products = CRUDUtils.getProductData("SELECT * FROM products");
//        System.out.println(products);

    }


}
