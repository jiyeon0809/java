package org.example;

public class start {
    public static void main(String[] args) {
        Members_managementIpl a = new members_management();

        while(true) {
            int myChoice = a.printMenu();
            switch(myChoice) {
                case 1:
                    a.signUp();
                    break;
                case 2:
                    a.signIn();
                    break;
                case 3:
                    System.out.println("The program will exit now.");
                    return;
            }

        }
    }
}
