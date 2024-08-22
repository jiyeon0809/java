package com.himedia.java;
//변수: 값을 저장할 수 있는 메모리상의 공간
//변수 타입: 변술에 저장될 값이 어떤 탕ㅂ인지를 지정하는 것ㄱ
//변수 이름: 변수에 붙인 이름
//변수 초기화: 변수를 사용하기 전에 처음으로 값을 저장하는 것

//변수의 명명 규칙
//1.대소문자가 구분되어 길이에 제한없다
//2. 예약어를 사용해서는 안된다. ex) true, false, break, int, for,...
//3. 숫자로 시작하면 안된다
//4.특수문자:'_"와 '$"만을 허용한다


//변수의 타입
//기본형(Primitive type)괴ㅏ 참조형(Reference Type)
//자료형은 크게 '기본형'과 '참조형' 두 가지로 나눌 수 있는데,
//기본형 변수는 실제 값(data)를 저장하는 반ㅁ면
//참조형 변순는 어떤 값이 저장되어 있는 주소ㅗ (memory address)를 값으로 갖느다
//기본형: 논리형(boolean), 문자형ㄴ(char), 정수형(byte, short, int, long), 시;ㄹ수형(float, double)
//참조형: 객체의 주소를 저장한다. 기본형 제외 나머지 타입

//기본형
//-논리형: boolean
// true와 false 중 하나의 값을 갖으면, 조건식과 논리적 계산에 사용한다
//크기: 1byte
//-문자형: char
//문자를 저장하는데 사용되며 하나의 문자만 저장할 수 있다
// 크기:20byte
//범위:
//-정수형: byte, short, int, long
//정수를 저장하는데 사용된다. byte는 이진데이터를 다룰 때 short는 c언어와의 호환을 위해 추가되었ㄷ
//크기: byte(1byte-8bit), short(2byte), inr(4byte), long(8byte)
//범위: byte(-128~127) short(-32,768 ~ 32,767)
//-실수형: float, double
//범위: float(1.4E-45 ~ 3.4028235E38)

//상수(Constant): 변수와 마찬가지로 값을 저장할 수 있는 공간이지만
//변수와 달리 한 번 값을 저장하면 다른 값으로 변경할 수 없다

/*
함수: 프로그램ㅇ에서 특정작업을 수행하기 위해 작성된 코드 묶음
1. 함수 선언: 함수의 이름과 특성을 정의하는 부분이다
2.매개변수: 매개변수는 함수가 작업을 수행하는데 필요한 입력값을 전달받는 부분이다
3. 변환 타입: 함수가 어떤 유형의 거ㅏㅄ을 변환할지 정의
 */

//*return
//1. 값을 반환: 함수가 어떤 값을 처리한 후 그 결과를 호출한 코드로 돌려준다
//2. 함수 종료: return문이 실행되면 해당함수가 즉시 종료가 된다

public class B_variable_function {

    public static int add(int a, int b){
        int sum=a+b;
        return sum;
    }
    //minus 함수
    public static int minus(int a, int b){
        int min=a-b;
        return min;
    }

    //multiply 함수
    public static int multiply(int a, int b){
        int multiply=a*b;
        return multiply;
    }

    //devide 함수: 소수점으로 반환받는다
    public static double devide(int a, int b){
        return a / b;
    }

    public void exam1(){





    }


    public static void main(String[] args){
        String myStr="안녕하세요!";
        System.out.println(myStr);
        int num=10;
        System.out.println(num);

        byte bNum=127;
        System.out.println(bNum);

        float fNum=3.14f;
        System.out.println(fNum);

        final float PI=3.14f;
        //PI=3.15;//에러

        int result=add(3, 5);
        System.out.println(result);

        int a=10;
        int b=3;
        result=minus(a,b);
        System.out.println(result);
        result=multiply(a,b);
        double dResult=devide(a,b);
        System.out.println(dResult);
    }
}
