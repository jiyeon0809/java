package org.example;

import java.sql.*;

public class A_jdbc {

    public Connection connection() throws ClassNotFoundException, SQLException {
        String url ="jdbc:mysql://@localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conn Success!");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertData(String name, int age, String phone){
        String query = "INSERT INTO users (name, age, phone) VALUES (?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, phone);

            int result = preparedStatement.executeUpdate();
            if (result > 0 ) {
                System.out.println("Insert success");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(int id, String name, int age, String phone){

        String query = "UPDATE users SET name = ?, age = ?, phone = ? WHERE id = ?";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, id);
            int result = preparedStatement.executeUpdate();

            if (result > 0 ) {
                System.out.println("Update success");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectOne(int id){
        String query = "SELECT id, name, age, phone FROM users WHERE id = ?";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
                ){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");

                System.out.println(id+" : "+name + " : " + age + " : " + phone + " : " + id);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(int id){
        String query = "DELETE FROM users WHERE id = ?";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
                ){
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();
            if (result > 0 ) {
                System.out.println("Delete success");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectAll(){
        String query = "SELECT * FROM users";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
                ){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                System.out.println(id+" : "+name + " : " + age + " : " + phone);
                System.out.println("============================================");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        A_jdbc jdbc = new A_jdbc();
        jdbc.insertData("Alice",11,"010-1234-5678");
        jdbc.insertData("John",11,"010-1234-5678");
        jdbc.insertData("Paul",11,"010-1234-5678");
        jdbc.insertData("Sally",11,"010-1234-5678");
       // jdbc.insertData("Alice",11,"010-1234-5678");
       // jdbc.selectOne(4);
       // jdbc.updateData(4,"Sally",13,"010-1111-2222");
       // jdbc.selectOne(4);
       // jdbc.deleteData(4);
        jdbc.selectAll();
    }
}
