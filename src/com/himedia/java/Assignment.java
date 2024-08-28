package com.himedia.java;

import java.util.Scanner;

public class Assignment {

    public static int COKE=500, CIDER=300, FANTA=700, WATER=200;
    public static int totalMoney=0;

    public static int printMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("[1]콜라 [2]사이다 [3]환타 [4]물 [5]돈넣기 [6]반환");
        System.out.printf("현재잔액: %d원 \n",totalMoney);
        int choice=sc.nextInt();
        return choice;
    }

    public static void getMoney(){
        Scanner sc=new Scanner(System.in);
        System.out.println("넣을 돈을 입력하세요");
        totalMoney+=sc.nextInt();
    }

    public static void main(String[] args) {

        while(true){
            switch(printMenu()){
                case 1:
                if(0>totalMoney){
                    System.out.println("잔액이부족합니다");
                }else{
                    System.out.println(totalMoney-COKE);
                    totalMoney-=COKE;
                }
                break;
                case 2:
                    if(0>totalMoney){
                        System.out.println("잔액이부족합니다");
                    }else{
                        System.out.println(totalMoney-CIDER);
                        totalMoney-=CIDER;
                    }
                    break;
                case 3:
                    if(0>totalMoney){
                        System.out.println("잔액이부족합니다");
                    }else{
                        System.out.println(totalMoney-FANTA);
                        totalMoney-=FANTA;
                    }
                    break;
                case 4:
                    if(0>totalMoney){
                        System.out.println("잔액이부족합니다");
                    }else{
                        System.out.println(totalMoney-WATER);
                        totalMoney-=WATER;
                    }
                    break;
                case 5:
                getMoney();
                break;
                case 6:
                System.out.println("프로그램이 종료되었습니다");
                return;
            }
        }

    }
}
