package com.himedia.java;

//메서드
//특정작업을 수행하는 문장을 하나로 묶은 것

//메서드 사용 이유
//1.높은 재사용성
//2.중복돈 코드 제거
//3.프로그램 구조화

//메서드의 선언과 구현
//메서드는 크게 두부분 선언부와 구현부로 이루어져있다
//메서드 선언부: 메서드 이름, 매개변수 선언 그리고 반환타입으로 이루어져있다
//매서드가 작업을 수행하기 위해 어떤 값들을 필요로 하고 작업의 결과로 어떤 타입 값을
//반횐하는지에 대한 정보를 제공한다
/*
public int add (int a int b) ->선언부
{
//->구현부
return a+b;
}
 */
//메섣그 호출: 메서드를 정의했어도 호출하지 않으면 사용되지 않는다
/*
메서드 이름(값1, 값2,값3...); //메서드 호출법
 */

public class B_method {
    public static void main(String[] args) {
        B_calculator calc = new B_calculator();

        int result = calc.add(1,2);
        System.out.println(result);
        result = calc.minus(3,2);
        System.out.println(result);
        result = calc.multi(5,2);
        System.out.println(result);
        result = calc.divide(5,2);
        System.out.println(result);
    }
}
