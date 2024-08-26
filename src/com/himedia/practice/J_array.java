package com.himedia.practice;

public class J_array {

    public static void exam1(){
        int[] score=new int[3];
        score[0]=10;
        score[1]=20;
        score[2]=30;
        System.out.println(score);
        System.out.println(score[0]);
    }

    public static void exam2(){
        int[] score={10, 20, 30};
        System.out.println(score.length);
        System.out.println(score[0]);
    }

    public static void exam3(){
        int[] score=new int[3];
        for(int i=0;i<score.length;i++){
            score[i]=10*i;
        }
        for(int s : score){
            System.out.println(s);
        }
    }

    public static void exam4(){
        char[] words={'h','e','i','l','l','o'};
        for(char c : words){
            System.out.println(c);
        }
    }

    public static void exam5(){
        String[] temp=new String[2];
        temp[0]="hello";
        temp[1]="world";
        String[] words={"hello","world"};
        for(String s : words){
            System.out.println(s);
        }
    }

public static void exam6(int[]score, int num){
        score[1]=90;
        num=90;
}

public static void exam6_1(){
        int[] score={10, 20, 30};
        int num=20;

        for(int i=0;i<score.length;i++){

        }
}

    public static void main(String[] args) {
        exam5();
    }
}
