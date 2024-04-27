package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();

        System.out.println("Введите цену продукта:");
        int price = scanner.nextInt();

        System.out.println("Введите количество продукта:");
        int quantity = scanner.nextInt();

        String query = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        CRUDUtils.saveProductData(query, name, price, quantity);

        List<Product> products = CRUDUtils.getProductData("SELECT * FROM products");
        System.out.println(products);


    }


}
