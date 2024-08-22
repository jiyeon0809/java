package com.himedia.java;

//*연산자
//-산술연산자: +,-,*,/,%
//-단항연산자: ++,--
//-비교연산자: >, <, =>, =<, ==, !=
//-논리연산자: &&, ||, !, &, \, ^, ~
//-대입연산자: =
//-기타: ? :, 복합대입연산자

//*연산자의 우선순위
//곱셈과 나눗셈은 덧셉과 뺄셈보다 우선순위가 높다

public class F_operater {

    public static void exam1(){
        int a=10;
        int b=4;

        System.out.printf("%d+%d=%d\n",a,b,(a+b));
        System.out.printf("%d-%d=%d\n",a,b,(a-b));
        System.out.printf("%d*%d=%d\n",a,b,(a*b));
        System.out.printf("%d/%d=%d\n",a,b,(a/b));
        System.out.printf("%d %% %d=%d\n",a,b,a%b);
    }
//단항연산자
    public static void exam2(){
        //증감연산자: 피연산자의 값을 1 증가시킨다
        //i=i+1, i+=1
        int i=5;
        System.out.println("===증감===");
        System.out.println("전위형 : "+ ++i);
        System.out.println("전위형 : "+ i++);
        System.out.println("결과 : "+ i);


        //갑소연산자: 피연산자의 값을 1 감소시킨다
        System.out.println("===증감===");
        System.out.println("전위형 : "+ --i);
        System.out.println("전위형 : "+ i--);
        System.out.println("결과 : "+ i);

    }
    //비교연산자
    public static void exam3(){
        System.out.printf("10==10.0f \t%b\n", 10==10.0f);
        System.out.printf("'0'==0 \t%b\n", '0'==0);
        System.out.printf("'A'==65 \t%b\n", 'A'==65);
        System.out.printf("'A'>'B' \t%b\n", 'A'>'B');
        System.out.printf("'A'+1 != 'B' \t%b\n", 'A'+1 != 'B');

    }
//[문자열 비교]
    //두 문자열을 비교할 떄는 비교연산자는 ==대신 equals()

    public static void exam4(){
        String str1= new String("Hello");
        String str2= new String("Hello");

        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        String str3= "Hello";
        String str4= "Hello";

        System.out.println(str3==str4);

    }

    //논리연산자
    //&&:and, 모두 true일때 true
    //||: or, 둘 중 하난만 true면 true
    //!: 논리부정연산-x가 true일 때 false


    public static void exam5(){
        boolean a=true;
        boolean b=false;
        boolean c=true;

        System.out.println("a&&b: "+(a&&b));
        System.out.println("a||b: "+(a||b));
        System.out.println("a&&c: "+(a&&c));
        System.out.println("!a: "+!a);

    }

    //[비트연산자]
    //|(OR연산자): 피연산자 중 한 쪽의 값이 1이면 1을 결과로 얻는다
    //&(And연산자): 피연ㄴ산자 중에 양쪽이 모두 1이어야만 1을 결과로 얻는다
    //^(XOR 연산자): 피연산자의 값이 서로 다를 때만 1을 결과로 업는다

    public static void main(String[] args) {
        exam1();
        exam2();
        exam3();
    }
}
