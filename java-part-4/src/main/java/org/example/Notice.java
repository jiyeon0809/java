package org.example;

public interface Notice {
    int printMenu();
    int signIn();
    void signUp();
    void showArticle();
    void writeArticle();
    void modifyArticle();
    void deleteArticle();
    void logOut();
    void signOut();
    void insertData(String name, String ID, String password);
    void insertData2(String article, String dateTime);
}
