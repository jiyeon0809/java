package himedia.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_review {



    public static int printMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("====================메뉴=====================");
        System.out.println("[1]댓글추가 [2]좋아요 [3]전체보기 [4]내용삭제 [5]종료");
        System.out.println("=============================================");
        return input.nextInt();
    }

    public static void addMember(String Id, String Review){
        Map<String, String> map = new HashMap<>();
        map.put(Id,Review);
        System.out.println("[리뷰]"+map);
    }

    public static String[] printScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("사용자 아이디를 입력하세요");
        String Id = in.nextLine();
        System.out.println("내용을 입력하세요");
        String Review = in.nextLine();
        return new String[]{Id,Review};
    }



    public static void main(String[] args) {
        while(true){
             String Id = "", Review = "";
            switch(printMenu()){
                case 1:
                    String[] printScreen= printScreen();
                    Id = printScreen[0];
                    Review = printScreen[1];
                    break;
                    case 2:
                        break;
                        case 3:
                            addMember(Id, Review);
                            break;
                            case 4:
                                break;
                                case 5:
                                    System.out.println("프로그램이 종료되었습니다");
                                    return;
            }
        }

    }
}


