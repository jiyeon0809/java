package himedia.java;

public class Start {

    public static void main(String[] args) {
        AccountBook a = new AccountBookImpl();
        while(true){
            int myChoice = a.printMenu();
            switch(myChoice){
                case 1:
                    a.addItemsList();
                    break;
                case 2:
                    a.showHistory();
                    break;
                case 3:
                    a.deleteAllItems();
                    break;
                case 4:
                    a.deleteSomeItems(String[]);
                    break;
                case 5:
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }


    }
}
