/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBContext {

    public List<Account> findAll() {
        List<Account> listFound = new ArrayList<>();
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Account]";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username").trim();
                String password = resultSet.getString("password").trim();
                String displayName = resultSet.getString("displayName").trim();
                String address = resultSet.getString("address").trim();
                String email = resultSet.getString("email").trim();
                String phone = resultSet.getString("phone").trim();
                Account account = new Account(id, username, password, displayName, address, email, phone);
                listFound.add(account);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listFound;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.findAll();
        for (Account o : list) {
            System.err.println(o);
        }
    }

    public Account findByUsernamePassword(String user, String pass) {
        //- connect with DB
        connection = getConnecttion();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "where username = ? and password = ?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setObject(1, user);
            statement.setObject(2, pass);
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //- trả về kết quả
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username").trim();
                String password = resultSet.getString("password").trim();
                String displayName = resultSet.getString("displayName").trim();
                String address = resultSet.getString("address").trim();
                String email = resultSet.getString("email").trim();
                String phone = resultSet.getString("phone").trim();
                Account account = new Account(id, username, password, displayName, address, email, phone);
                return account;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
