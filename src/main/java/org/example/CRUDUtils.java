package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    public static List<Product> getProductData(String query){
        List<Product> products = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity_in_stock = rs.getInt("quantity_in_stock");
                int quantity_sold = rs.getInt("quantity_sold");

                products.add(new Product(id, name, price, quantity_in_stock, quantity_sold));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return products;

    }

    public static List<Product> saveProductData(String INSERT_PRODUCT, String name, int price, int quantity_in_stock, int quantity_sold){
        List<Product> products = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(3, quantity_in_stock);
            preparedStatement.setInt(4, quantity_sold);
            preparedStatement.executeUpdate();
            System.out.println("Данные успешно добавлены в базу данных.");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return products;

    }

    public static void updateProductPrice(String query, int newPrice, int productId) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newPrice);
            preparedStatement.setInt(2, productId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Цена товара успешно обновлена.");
            } else {
                System.out.println("Товар с указанным идентификатором не найден.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public static void updateProductQuantity(String query, int productId, int newQuantity) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
            System.out.println("Количество товара успешно обновлено в базе данных.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(String query, int productId) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Товар успешно удален из базы данных.");
            } else {
                System.out.println("Товар с указанным ID не найден в базе данных.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void updateProductQuantity(int productId, int quantitySold) {
        String UPDATE_QUANTITY = "UPDATE products SET quantity_in_stock = quantity_in_stock - ?, quantity_sold = quantity_sold + ? WHERE id = ?";
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY)) {
            preparedStatement.setInt(1, quantitySold);
            preparedStatement.setInt(2, quantitySold);
            preparedStatement.setInt(3, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static int getTotalValueOfProducts(String GET_TOTAL_VALUE) {

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TOTAL_VALUE);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }





    public static List<Employee> getEmployeeData(String query){
        List<Employee> employees = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("+------+-----------------+-----------------+-----------------+------------+");
            System.out.println("| ID   | Name            | Surname         | Post            | Salary     |");
            System.out.println("+------+-----------------+-----------------+-----------------+------------+");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String post = rs.getString("post");
                int salary = rs.getInt("salary");
                System.out.printf("| %-4d | %-15s | %-15s | %-15s | %-10d |%n", id, name, surname, post, salary);
            }
            System.out.println("+------+-----------------+-----------------+-----------------+------------+");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return employees;

    }

    public static List<Employee> saveEmployeeData(String INSERT_EMPLOYEE, String name, String surname, String post, int salary){
        List<Employee> employees = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, post);
            preparedStatement.setInt(4, salary);
            preparedStatement.executeUpdate();
            System.out.println("Данные успешно добавлены в базу данных.");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return employees;

    }

    public static void updateEmployeesSalary(String query, int newSalary, int employeeId) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newSalary);
            preparedStatement.setInt(2, employeeId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Зарплата работника успешно обновлена.");
            } else {
                System.out.println("Работник с указанным ID не найден.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }


    public static void updateEmployeesPost(String query, String newPost, int employeeId) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newPost);
            preparedStatement.setInt(2, employeeId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Должность работника успешно обновлена.");
            } else {
                System.out.println("Работник с указанным ID не найден.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public static void deleteEmployee(String query, int employeeId) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Работник успешно удален из базы данных.");
            } else {
                System.out.println("Работник с указанным ID не найден в базе данных.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
