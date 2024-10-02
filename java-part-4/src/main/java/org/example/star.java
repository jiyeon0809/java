package org.example;

public class star {
    public static void main(String[] args) {

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0 ; j < i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = 5 - i ; k > 0; k--) {
//                    System.out.print("*");
//                }
//            System.out.println();
//            }

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0 ; j < i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//            if(i==4){
//                for (int j = i ; j > 0; j--) {
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//            }
//        }


        for (int i = 1; i <= 10 - 1; i++) {
            if (i <= 5) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <= 10 - i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
