package org.example;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class NoticeImpl implements Notice {


    private int result1=0;

    public Connection connection()  {
        String url = "jdbc:mysql://localhost:3306/learn_database";
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



    @Override
    public int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("1.sign in 2.sign up 3.show articles 4. write new article");
        System.out.println("5.modify article 6.delete article");
        System.out.println("6.log out 7.sign out 8. exiting the program");
        System.out.println("=============================================================");
        return scanner.nextInt();
    }


    @Override
    public int signIn() {
        String query = "SELECT ID, password, name FROM users WHERE ID=? and password = ?";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your ID: ");
            String ID1 = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password1 = scanner.nextLine();

            preparedStatement.setString(1, ID1);
            preparedStatement.setString(2, password1);


            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                System.out.println("You are logged in!");
                System.out.println("Welcome " + resultSet.getString("name") + "!");
                return result1=-1;
            }else{
                System.out.println("You are not logged in!");
                return result1=-2;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        insertData(name, ID, password);


    }

    @Override
    public void showArticle() {
        String query = "SELECT article, dateTime FROM content";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Time: " + resultSet.getString("dateTime"));
            System.out.println("Article: " +resultSet.getString("article"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void writeArticle() {

        if(result1==-1){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write a new article: ");
            String article = scanner.nextLine();
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            String dateTime = dateFormat.format(new Date()).toString();
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Time : " + dateTime);
            System.out.println("Article: " + article);
            insertData2(article, dateTime);
        }else{
            System.out.println("You need to log in first to write new article");
            return;
        }


    }

    @Override
    public void modifyArticle() {

        String query = "UPDATE content SET article = ?, dateTime = ? WHERE id = ?";

        if(result1==-1){
            try (
                    Connection conn = connection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
            ) {

                Scanner sc = new Scanner(System.in);
                System.out.println("Modify your article: ");
                String newArticle = sc.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                String newDateTime = dateFormat.format(new Date());

                preparedStatement.setString(1, newArticle);
                preparedStatement.setString(2, newDateTime);

                insertData2(newArticle, newDateTime);

                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    System.out.println("Update Success!");
                    System.out.println("Time: " + newDateTime);
                    System.out.println("Article: " + newArticle);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("You need to log in first to modify an article");
            return;
        }


    }

    @Override
    public void deleteArticle() {

        String query = "DELETE FROM users WHERE ID = ?";

        if(result1==-1){
            try (
                    Connection conn = connection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
            ) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your ID: ");
                String ID = sc.nextLine();

                preparedStatement.setString(1, ID);

                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    System.out.println("Delete Success!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("You need to log in first to delete an article");
            return;
        }


    }


    @Override
    public void logOut() {
        result1=-2;
        System.out.println("YOU LOGOUT SUCCESSFULLY");
    }


    @Override
    public void signOut() {
        String query = "SELECT id FROM users";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your ID to sign out: ");
            String ID = scanner.nextLine();

            preparedStatement.setString(1,ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.getString("id").equals(ID)) {

                System.out.println("You are signed out!");
            }else{
                System.out.println("You are not signed out!");
            }

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }




    @Override
    public void insertData(String name, String ID, String password) {
        String query = "INSERT INTO users (ID, password, name ) VALUES (?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            preparedStatement.setString(1,ID);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertData2(String article, String dateTime) {

        String query = "INSERT INTO content (article, dateTime) VALUES (?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            preparedStatement.setString(1, article);
            preparedStatement.setString(2, LocalDateTime.now().toString());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}














