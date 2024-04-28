package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seller {

    private final Scanner scanner;

    public Seller(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void displaySellerMenu() {
        System.out.println("1 | Продать товар.");
        System.out.println("2 | Завершить.");
    }

    public static void sellProduct(Scanner scanner) {
        List<SoldProduct> soldProducts = new ArrayList<>();
        boolean selling = true;
        while (selling) {
            System.out.println("Введите ID товара, который вы хотите продать (или 0 для завершения):");
            int productId = scanner.nextInt();
            int quantitySold = 0;
            if (productId == 0) {
                selling = false;
            }

            else{
                System.out.println("Введите количество проданных единиц товара:");
                quantitySold = scanner.nextInt();
                String UPDATE_QUANTITY = "UPDATE products SET quantity_in_stock = quantity_in_stock - ?, quantity_sold = quantity_sold + ? WHERE id = ?";
                CRUDUtils.sellProduct(UPDATE_QUANTITY, productId, quantitySold);
            }

            if(CRUDUtils.getProductName(productId) != null){
                SoldProduct soldProduct = new SoldProduct(productId, CRUDUtils.getProductName(productId), CRUDUtils.getProductPrice(productId), quantitySold);
                soldProducts.add(soldProduct);
            }


        }

        displayReceipt(soldProducts);
    }

    public static void displayReceipt(List<SoldProduct> soldProducts) {
        System.out.println("---------- Чек ----------");
        double total = 0.0;
        for (SoldProduct soldProduct : soldProducts) {
            System.out.println(soldProduct.getName() + "\t" + soldProduct.getPrice() + "\t" + soldProduct.getQuantity());
            total += soldProduct.getPrice() * soldProduct.getQuantity();
        }
        System.out.println("--------------------------");
        System.out.println("Total: " + total);
    }
}