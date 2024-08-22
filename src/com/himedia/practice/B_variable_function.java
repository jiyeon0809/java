package com.himedia.practice;

public class B_variable_function {
    public static int add(int a, int b){
        return a+b;
    }
    public static int minus(int a, int b){
        return a-b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static double devide(int a, int b){
        return a/b;
    }
    public static void main(String[] args){
        int a=10;
        int b= 3;
        int result=0;
        result=add(a,b);
        System.out.println(result);
        result=minus(a,b);
        System.out.println(result);
        result=multiply(a,b);
        System.out.println(result);
        double dResult=devide(a,b);
        System.out.println(dResult);


    }
}
