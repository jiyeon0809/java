package himedia.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Management {

    static int memberCapacity=0;
    static int memberCnt=0;

    private final boolean isStop;
    private final Scanner sc;
    private final ArrayList<Member>member;

    public Management() {
        isStop = false;
        sc = new Scanner(System.in);
        member = new ArrayList<Member>();
    }

    public static int printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("[1]Lite [2]Basic [3]Premium [4]Freepass");
        System.out.println("==========================================");
        return sc.nextInt();
    }


    public void start() throws IOException {
        while(!isStop) {
            int menu=-1;
            System.out.println("**메뉴선택**");
            System.out.printf("현재 회원 수 : %d/%d",memberCnt,memberCapacity);
            System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
            System.out.println("[4]전체조회 [5]회원정보수정 [6]회원삭제");
            System.out.println("[7]요금제변경 [8]초기화 [9]프로그램종료");

            try{
                menu=Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                menu=-1;
            }

            System.out.println();
            switch(menu){
                case 1:
                    addMember(); break;

                case 9:
                    System.out.println("프로그램이 종료되었습니다");
                    return;
            } //end switch

        }//end while
    }//end start


    public void addMember() throws IOException {
        System.out.println("이름 입력 : ");
        String name=sc.nextLine();
        System.out.println("이메일 입력 : ");
        String email=sc.nextLine();

        if(checkEmail(member, email)){
            System.out.println("이미 존재하는 회원입니다");
            return;
        }

        ArrayList<Integer> list = new ArrayList<>(memberCapacity);

    }


    public static int memberCapacity() {
        return -1;
    }

    public static boolean checkEmail(ArrayList<Member> member, String email) {
        for(Member m : member) {
            if(m.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

}
