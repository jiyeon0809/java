package org.example;

import java.util.Scanner;

public class NoticeImpl_1 implements Notice_1{

    private NoticeDAO noticeDAO;

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================== [My Notice] ===========================");
        System.out.println("[1]로그인 [2]회원가입 [3]글목록보기 [4]글등록 [5]글수정 [6]글삭제");
        System.out.println("[7]로그아웃 [8]회원탈퇴 [9]프로그램종료");
        System.out.println("==================================================================");
        System.out.println("번호를 입력하세요.");
        return sc.nextInt();
    }

    @Override
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String userId = scanner.nextLine();
        System.out.println("PW를 입력하세요.");
        String password = scanner.nextLine();
        System.out.println("사용자 이름을 입력하세요.");
        String name = scanner.nextLine();

       // if(noticeDAO.checkUserId(userId))
    }


}
