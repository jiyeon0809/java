package org.example;

import java.util.Scanner;

public class members_management implements Members_managementIpl {

    private int MAX = 1000;
    private String members [] = new String[MAX];



    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("1. Sign up 2. Sign in 3. Ending the program");
        System.out.println("==========================================");
        return sc.nextInt();
    }

    @Override
    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your id : ");
        String id = sc.nextLine();
        System.out.println("Please enter your password : ");
        String password = sc.nextLine();
        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Please enter your age : ");
        int age = sc.nextInt();
        System.out.println("Please enter your phone number : ");
        int phone = sc.nextInt();

        members[0] = id;
        members[1] = password;
        members[2] = name;
        members[3] = age+"";
        members[4] = phone+"";

    }

    @Override
    public void signIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your id : ");
        String id = sc.nextLine();
        System.out.println("Please enter your password : ");
        String password = sc.nextLine();

        if(members[0].equals(id) && members[1].equals(password)) {
            System.out.println("Welcome!"+members[2]);
            System.out.println("age : "+members[3]+"phone : "+members[4]);
        }else{
            System.out.println("Wrong id or password!");
        }
    }
}
