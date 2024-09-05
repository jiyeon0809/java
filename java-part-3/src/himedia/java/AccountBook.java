package himedia.java;

public interface AccountBook {
    int printMenu();
    String addItemsList();
    void showHistory();
    void deleteAllItems();
    void deleteSomeItems(String itemDate);
}
