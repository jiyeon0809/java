package com.himedia.java;

//정적 메소드
//클래스 메소드는 자바에서 static 키워드로 선언된 메서드 의미, 정적 메서드라고도 불림
//정적 메서드는 특정 클래스가 인스턴스에 종속되지 않으며, 클래스 자체에 속한다
//따라서 객체를 생성하지 않고도 클래스 이름을 통해 직접 호출할수있다
//클래스변수처럼 객체 생성안하고 클래스이믕.메서드이름과 같은 식으로 호출 가능

//주요특징
//1.인스턴스 필요없음
//2.정적 변수와 상수만 접근 가능
//정적 메서드는 다른 정적멤버와만 상호작용 가능
//인스턴스 변수나 인스턴스 메서드에는 직접 접근할 수 없다
//3.유틸리티메서드로 자주 사용
//자주 사용되거나 공통적인 작업을 사용하는 유틸리티 메서드는 일반적으로 정적 메서드로 구현
//예를들어 math 클래스의 Math.random() 메서드처럼 인스턴스와 관련이없는 계산작업 수행하는 경우가 많다

//결론
//정적 메서드는 클래스에 속하는 메서드로서, 특정 인스턴스와 관계없이 호출할 수 있다
//주로 유틸리티 성격의 메서드나 클래스 자체의 특성과 관련된 메서드 정의 시 유용

public class D_static_method {
    public static void main(String[] args) {

        double multi= D_calc.multi(2.1,3.2);
        System.out.println(multi);
        double add= D_calc.add(2.1,3.2);
        System.out.println(add);
        double circleArea= D_calc.circleArea(3);
        System.out.println(circleArea);
    }
}
