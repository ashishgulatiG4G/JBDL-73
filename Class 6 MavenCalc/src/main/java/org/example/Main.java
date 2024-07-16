package org.example;

public class Main {
    public static void main(String[] args) {
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b) {
        return Math.abs(a-b);
    }
    public static int multiply(int a, int b) {
        return a*b;
    }
    public static int divide(int a, int b) {
        return a/b;
    }

    public static int power(int a, int b) {
        return (int)Math.pow(a, b);
    }
}