package org.example;

public class MultipleTryCatch {

    public void check() {

         /*
            Multiple catch blocks
         */



//        try {
//            Class<?> clas = Class.forName("com.example.UncheckedExceptions");
//
//
//            int[] arr = new int[5];
//            arr[5] = 12;
//            arr[4] = 50/0;
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException");
//        } catch (RuntimeException ex) {
//            System.out.println("RuntimeException");
//        } catch (Exception ex) {
//            System.out.println("Generic Exception");
//        }
//
//        System.out.println("After try catch");


        /*
            Nested try blocks

            try {
                stat1
                stat2
                    try {
                        stat
                    } catch () {

                    }

            } catch () {

            }

         */

        try {
            try {
                int a = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            System.out.println("After Arithmetic Exception");

            try {
                int arr[] = new int[5];
                arr[5] = 5;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                throw new Exception(e);
            }

            System.out.println("After AIOut of Bound");

        } catch (Exception ex) {
            System.out.println("Handled");
        }


    }








}
