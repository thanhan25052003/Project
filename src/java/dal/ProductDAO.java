/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author admin
 */
public class ProductDAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM Product";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description").trim();
                String imageUrl = resultSet.getString("imageUrl").trim();
                String created_date = resultSet.getString("created_date").trim();
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(id, name, quantity, price, description, imageUrl, created_date, category_id);
                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProducts();
        for (Product o : list) {
            System.err.println(o);
        }

    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM Product WHERE category_id = ?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setInt(1, categoryId);
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description").trim();
                String imageUrl = resultSet.getString("imageUrl").trim();
                String created_date = resultSet.getString("created_date").trim();
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(id, name, quantity, price, description, imageUrl, created_date, category_id);
                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM Product WHERE [name] LIKE ?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setString(1, "%" + txtSearch + "%");
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description").trim();
                String imageUrl = resultSet.getString("imageUrl").trim();
                String created_date = resultSet.getString("created_date").trim();
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(id, name, quantity, price, description, imageUrl, created_date, category_id);
                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public List<Product> getProductById(int productId) {
        List<Product> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM Product WHERE id = ?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId); // Set the value for the first parameter
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description").trim();
                String imageUrl = resultSet.getString("imageUrl").trim();
                String created_date = resultSet.getString("created_date").trim();
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(id, name, quantity, price, description, imageUrl, created_date, category_id);
                listFound.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }
}
