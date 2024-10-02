package org.example;

public class Start_1 {
    public static void main(String[] args) {
        Notice_1 n = new NoticeImpl_1();

        while(true) {
            int choice = n.printMenu();
            switch(choice) {
                case 2:
                    n.signUp();

                case 9:
                    System.out.println("다음에 또 만나요 ! ");
                    return;

            }

        }
    }
}
