package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Laptop {
    private String make;
    private int price;

    public Laptop(String make, int price) {
        this.make = make;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Price: " + price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.make == null) ? 0 : make.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Laptop other = (Laptop) obj;
        if(this.make == null) {
            if(other.make != null) return false;
        } else if(!this.make.equals(other.make)) {
            return false;
        }

        return this.price == other.price;
    }


    @Override
    public Laptop clone() {
        return new Laptop(this.make, this.price);
    }







}


public class Main {
    public static void main(String[] args) {
       /*
            Object class is the parent of all the classes
        */

        Laptop mac = new Laptop("Apple", 100000);
        System.out.println(mac.toString());

        // 2. getClass()
        System.out.println(mac.getClass().getName());


        Laptop lenovo = new Laptop("Lenovo", 100000);
        System.out.println(mac.toString());

        //3. hashcode()
        System.out.println(mac.hashCode());
        System.out.println(lenovo.hashCode());

//        468121027
//        1804094807

        // 4. equals() method
        System.out.println(mac.equals(lenovo));

        Laptop laptop1 = mac.clone();
        System.out.println(laptop1.equals(mac));
        System.out.println(laptop1);

//        HashMap



    }
}

/*
    If you override the equals method() -> you must override the hashcode method

    Because if two objects are equal according to equals method -> then calling the
    hashcode method must generate the same value

    If two objects are unequal according to equals methods -> calling the hashCode method might generate the same value;



 */