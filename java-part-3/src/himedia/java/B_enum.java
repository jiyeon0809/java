package himedia.java;

//enum(열거형)
//자바에서 특정한 상수 집합을 정의하는데 사용되는 특별한 데이터 타입이다
//예를 들어 요일, 색상, 방향 등과 같은 고정된 개수와 상수들을 나타낼 때 유용핟가
//enum 클래스처럼 보이지만 시ㄹ제로는 고정된 상수들의 집합을 정의하는 것이며
//모든 enum은 java.lang.Enum 클래스를 상속받는다

//enum 사용의 장점
//코드의 명확성
//타입 안정성
//유지보수 용이성

public class B_enum {

    public static void exam1(){
        B_day today = B_day.TUESDAY;
        System.out.println(B_day.TUESDAY);
        switch (today) {
            case MONDAY:
                System.out.println("Today is MONDAY");
                break;
            case TUESDAY:
                System.out.println("Today is TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Today is WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Today is THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Today is FRIDAY");
                break;
            case SATURDAY:
                System.out.println("Today is SATURDAY");
                break;
            case SUNDAY:
                System.out.println("Today is SUNDAY");
                break;
        }
    }

    public static void main(String[] args) {
        exam1();
    }
}
