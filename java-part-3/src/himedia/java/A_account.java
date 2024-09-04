package himedia.java;


public interface A_account {
    void printCreateAccountMenu();
    String createAccountNum();
    int printMenu();
    boolean checkDuplicateNum(int[] accountNums, int tmp, int idx);
    void addMoney();
    void manageHistory(String message);
    void printHistory();
    void subMoney();
    String getNowDateTime();
}
