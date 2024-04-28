package org.example;

import java.util.Scanner;

public class WarehouseManager {
    private final Scanner scanner1;
    public WarehouseManager(Scanner scanner1) {
        this.scanner1 = scanner1;
    }

    public static void displayWarehouseManagerMenu() {
        System.out.println("1 | Прием и отгрузка товаров.");
        System.out.println("2 | Изменение цены товара.");
        System.out.println("3 | Данные продуктов на складе.");
        System.out.println("4 | Добавить новый товар.");
        System.out.println("5 | Удалить товар.");
        System.out.println("6 | Завершить работу.");
    }

    public static void updateProductPrice(Scanner scanner){
        System.out.println("Введите ID товара:");
        int id = scanner.nextInt();
        System.out.println("Введиде новую цену продукта:");
        int newPrice = scanner.nextInt();
        CRUDUtils.updateProductPrice(newPrice, id);
    }
    public static void showAllProducts (){
        CRUDUtils.getProductData();
    }

    public static void addNewProduct(Scanner scanner, Scanner intScanner){
        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();

        System.out.println("Введите цену продукта:");
        int price = intScanner.nextInt();

        System.out.println("Введите количество продукта:");
        int quantity = intScanner.nextInt();

        CRUDUtils.saveProductData(name, price, quantity, 0);
    }

    public static void ProductsAcceptance(Scanner scanner){
        System.out.println("Введите ID получаемого товара:");
        int id = scanner.nextInt();
        System.out.println("Введите количество товара:");
        int quantity = scanner.nextInt();
        String UPDATE_QUANTITY = "UPDATE products SET quantity_in_stock = quantity_in_stock + ? WHERE id = ?";
        CRUDUtils.updateProductQuantity(UPDATE_QUANTITY, id, quantity);

    }

    public static void ProductsShipment(Scanner scanner){
        System.out.println("Введите ID отгружаемого товара:");
        int id = scanner.nextInt();
        System.out.println("Введите количество товара:");
        int quantity = scanner.nextInt();
        String UPDATE_QUANTITY = "UPDATE products SET quantity_in_stock = quantity_in_stock - ? WHERE id = ?";
        CRUDUtils.updateProductQuantity(UPDATE_QUANTITY, id, quantity);

    }

    public static void removeProduct(Scanner scanner){
        System.out.println("Введите ID удаляемого товара:");
        int id = scanner.nextInt();
        CRUDUtils.deleteProduct(id);
    }
}
