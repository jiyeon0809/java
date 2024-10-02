package org.example;

public class N_start {
    public static void main(String[] args) {
        Notice n = new NoticeImpl();
        while(true) {
            int myChoice = n.printMenu();
            switch(myChoice) {
                case 1:
                    n.signIn();
                    break;
                case 2:
                    n.signUp();
                    break;
                case 3:
                    n.showArticle();
                    break;
                case 4:
                    n.writeArticle();
                    break;
                case 5:
                    n.modifyArticle();
                    break;
                case 6:
                    n.deleteArticle();
                    break;
                case 7:
                    n.logOut();
                    break;
                case 8:
                    n.signOut();
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    return;

            }
        }
    }
}
