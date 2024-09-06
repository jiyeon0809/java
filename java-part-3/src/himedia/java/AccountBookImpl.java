package himedia.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountBookImpl implements AccountBook {

    final int MAX = 100;
    private List<String> itemsList = new ArrayList<String>();
    private String itemDate [] = new String[MAX];
    private String item [] = new String[MAX];
    private int itemMoney [] = new int[MAX];
    private String today;

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("[1]가계부 내역 추가 [2]내역조회 [3]전체삭제 [4]내역삭제 [5] 프로그램 종료");
        System.out.println("================================================================");
        return sc.nextInt();
    }

    @Override
    public String addItemsList() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < MAX; i++) {
            System.out.println("날짜");
            today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(today);
            itemDate[i] = today;
            System.out.println("품명을 입력하세요");
            item[i] = sc.nextLine();
            System.out.println("금액을 입력하세요");
            itemMoney[i] = sc.nextInt();
            System.out.println("[날짜]"+itemDate[i]+"[품명]"+item[i]+"[금액]"+itemMoney[i]);
            itemsList.add("[날짜]"+itemDate[i]+"[품명]"+item[i]+"[금액]"+itemMoney[i]);
            break;
        }
        return sc.nextLine();
    }

    @Override
    public void showHistory() {
        for( String s : itemsList ){
            System.out.println(s);
        }
    }

    @Override
    public void deleteAllItems() {
        itemsList.clear();
        System.out.println("항목이 모두 삭제되었습니다.");
    }

    @Override
    public void deleteSomeItems() {

        for (int j = 0; j < itemsList.size(); j++) {
            System.out.println("[" + j + "] " + itemsList.get(j));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 내역을 선택하세요");
        int idx = sc.nextInt();
        itemsList.remove(idx);
    }
}
