package com.himedia.java;

//생성자 constructor
//객체가 생성될때 호출되는 특수한 메서드다.
//생성자는 초기 상태를 설정하는데 사용되며
//클래스 이름과 동일한 이름을 가져야한다.
//생성자는 반환타입이 없으며 객제가 생성될때 자동으로 호출된다

//생성자의 종류
//1. 기본 생성자 default constructor
//매개변수가 없는 생성자
//클래스에 생성자가 저의되지 않으면 컴파일러는 자동으로 기본 생성자를 추가한다

//2. 매개변수가 있는 생성자 parameterised constructor
//객체를 생성할 때 인수를 전달받아 필드를 초기화하는 생성자다
//여러개의 생성자를 오버로딩하여 다양한 초기화 방법을 제공할 수 있다

//복사생성자
//동인한 클래스의 다른 객체를 복사하여 새로운 객체를 생성하는 생성자다
//자바에서는 기본적으로 제공되지 않지만 필요에 따라 개발자가 구현할 수 있다

//생성자 역할과 이점
//객체 초기화: 생성자는 객체가 생성될 떄 필요한 초기값을 설정하는데 사용된다
//다양한 형태의 생성자를 제공함으로써 객체를 직관적ㄷ이고 간결하게 생성 가능
//생성자 오버로딩을 통해 객체 생성

public class F_constructor {
    public static void main(String[] args) {
        F_person1 p1 = new F_person1();
        p1.display();

        F_person2 p2 = new F_person2("John",13);
        p2.display();

        F_person3 p3= new F_person3();
        p3.display();

        p3 = new F_person3("john3");
        p3.display();

        p3 = new F_person3("John3", 13);
        p3.display();

        F_person4 p4= new F_person4("David",40);
        F_person4 pCopy= new F_person4(p4);

        p4.display();
        pCopy.display();


    }
}
