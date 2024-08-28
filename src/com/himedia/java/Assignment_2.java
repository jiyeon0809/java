package com.himedia.java;

import java.util.Scanner;

public class Assignment_2 {

    public static int totalMembers;
    public static int member=0;

    public static int printPriceMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]Lite 10명 [2]Basic 20명 [3]Premium 30명");
        return sc.nextInt();
    }

    public static int printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]회원추가 [2]회원조회 [3]회원정보수정 [4]회원삭제 [5]프로그램 종료");
        System.out.printf("인원수: %d/%d\n",member,totalMembers);
        return sc.nextInt();
    }

    public static void addMember(String[][] members){
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요");
        String name = sc.nextLine();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("이메일을 입력하세요");
        String email = sc1.nextLine();

        for(int i=0; i<totalMembers; i++){
            if(email.equals(members[i][1])){
                System.out.println("중복된 이메일은 사용 불가능합니다");
                return;
            }
        }
        members[member][0] = name;
        members[member][1] = email;
        System.out.println("연락처를 입력하세요");
        String phone = sc1.nextLine();
        members[member][2] = phone;
        member++;
    }

    public static void selectEmail(String[][] members){
        Scanner sc = new Scanner(System.in);
        System.out.println("이메일을 입력하세요");
        String email = sc.nextLine();
        for(int i=0; i<totalMembers; i++){
            if(email.equals(members[i][1])){
                System.out.println(members[i][0]+members[i][1]+members[i][2]);
            }
        }
    }

    public static void main(String[] args) {

        totalMembers = printPriceMenu()*10;

        String[][] members = new String[totalMembers][3];

        while(true){
            switch(printMenu()){
                case 1:
                    addMember(members);
                    break;
                case 5:
                    System.out.println("프로그램이 종료되었습니다");
                    return;
            }
        }

    }
}
