package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoticeDAO {
    private Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3306/notice";
        final String user = "root";
        final String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserId(String userId) throws SQLException {
        String query = "select count(*) from user where user_id=?";

        try(
                Connection connection = getConnection();
             //   preparedStatement preparedStatement = connection.prepareStatement(query)
        ){

          //  preparedStatement
        }


        return false;
    }
}
