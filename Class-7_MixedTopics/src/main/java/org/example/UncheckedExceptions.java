package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UncheckedExceptions {
    public void check() {
        System.out.println("Inside check");

        try {
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Handled exception");
        }

        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException _) {
            System.out.println("NullPointer exception");
        }

        try {
            List<Integer> arrayList = new ArrayList<>();
            System.out.println(arrayList.get(0));
        } catch (IndexOutOfBoundsException _) {
            System.out.println("IndexOutOfBoundsException");
        }

        try {
            String s = "2abc";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException n) {
            System.out.println("NumberFormat Exception");
        }



        System.out.println("After exception");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 6);

        list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
    }





}
