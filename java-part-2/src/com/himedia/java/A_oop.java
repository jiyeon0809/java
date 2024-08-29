package com.himedia.java;

//객체 지향프로그래밍 (object-Orientied programming)
//프로그래밍을 여러 개의 객체로 나누어 작성하는 법을 말한다
//재사용성과 유집보수성을 높이고
//복잡한 문제를 쉽게 해결하는데 중점

//class
//객체를 정의해 놓은 것
//객체 생성 시 사용

//객체
//실제로 존재하는 것, 사물 또는 객체

//인스턴스
//클래스로부터 객체를 만드는 과정을 클래스의 인스턴트화라고하며
//어떤 클래스로부터 만드렁진 객체를 그 클래스의 인스턴스라도 한다
//클래스--(인스턴스화)-->인스턴스(객체)


public class A_oop {

    public static void main(String[] args) {
        A_tv tv1 = new A_tv(); //객체 생성
        tv1.getColor();
        tv1.channelUp();
        tv1.channelDown();
        tv1.volumeUp();
        tv1.volumeDown();
        tv1.power();
    }
}
