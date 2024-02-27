/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAllCategories() {
        List<Category> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM Category";
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
                Category category = new Category(id, name);
                listFound.add(category);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<Category> list = dao.getAllCategories();
        for (Category o : list) {
            System.err.println(o);
        }

    }
}
