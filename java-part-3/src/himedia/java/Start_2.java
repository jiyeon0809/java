package himedia.java;

public class Start_2 {
    public static void main(String[] args) {
        AccountBook_2 a = new AccountBookImpl_2();
        while(true){
            int myChoice = a.printMenu();
            switch(myChoice){
                case 1:
                    a.createNewFile();
                    a.writeToFile();
                    break;
                case 2:
                    a.readFromFile();
                    break;
                case 3:
                    a.deleteSomeFiles();
                    break;
                case 4:
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
            }
        }
    }
}
