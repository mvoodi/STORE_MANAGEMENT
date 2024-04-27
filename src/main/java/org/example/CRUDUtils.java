package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    String INSERT_PRODUCT = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

    public static List<Product> getProductData(String query){
        List<Product> products = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");

                products.add(new Product(id, name, price, quantity));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return products;

    }

    public static List<Product> saveProductData(String INSERT_PRODUCT, String name, int price, int quantity){
        List<Product> products = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
            System.out.println("Данные успешно добавлены в базу данных.");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return products;

    }
}
