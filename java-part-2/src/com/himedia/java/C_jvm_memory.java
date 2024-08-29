package com.himedia.java;

//jvm 메모리 구조
//1.매서드 영역
//프로그램 실행 중 어떤 클래스가 실행되면 jvm은 해당 클래스 파일을 읽어서 분석하여
//클래스에 대한 정보를 이곳에 저장한다
//이 때 그 글래스의 클래스 변수도 이 영역에 함께 생성된다

//2. 힙 heap
//인스턴스가 생성되는 공간, 프로그램 실행 중 생성되는 인스턴스는 이곳에 생성된다

//3.호출스택 call stack
//호출스택은 매서드 작업에 필요한 메모리 공간을 제공한다
//호출되면 호출된 메서드를 위한 메모리가 할당되며
//이 메모리는 작업을 수행하는 동안 지역변수 들과 연산의 중간결과를 저장하는데 사용
//메서드가 작업 마치면 할당되었던 메모리 공간은 반환되어 비어진다

//메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할ㄹ당
//수행 마치면 사용된 메모리를 반환하고 스택에서 제거된다
//호출 스택 젤 위에 메서드가 현재 실행중인 거

//기본형 매개변수: 변수의 값을 읽기만 할 수 있다
//참조형 매개변수: 변수의 값을 읽고 변경할 수 있다

class Data{
    int x=5;
}




public class C_jvm_memory {
    public static void main(String[] args) {
        C_jvm_memory jvm = new C_jvm_memory();
        jvm.exam1();
    }
    public void exam1(){

    }

    public void firstMethod(){
        firstMethod();
    }
    public void secondMethod(){
        System.out.println("secondMethod");
    }
    public void exam2(){
        Data d =new Data();
        int x=5;
        System.out.println(d.x+" : "+x);
        changeData(d,x);
        System.out.println(d.x+" : "+x);
    }

    public void changeData(Data d, int x){
        d.x=d.x+1;
    }

    public void exam3(){
        Data d1 = new Data();
        d1.x=10;

        System.out.println("d1 : "+d1+" : "+d1.x);
        System.out.println("d1 : "+d1+" : "+d1.x);
    }

    public Data copy(Data d){
        Data tmp=new Data();
        tmp.x=d.x;
        return tmp;
    }

    public void exam4(){
        //재귀호출
        //매서드 내부에서 매서드 자신을 다시 호출
        int result= factorial(4);
        System.out.println(result);
    }

    public int factorial(int n){
        //기저조건
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }

}
