package org.example;

class Laptop {

    private String make;
    private int price;

    public Laptop(String make, int price) {
        this.make = make;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Make : " + make + ", Price : " + price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((make == null) ? 0 : make.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (make == null) {
            if (other.make != null)
                return false;
        } else if (!make.equals(other.make))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    @Override
    public Laptop clone() {
        return new Laptop(this.make, this.price);
    }


}


public class Main {

    public static void main(String[] args) {


        //1. toString()
        Laptop laptop = new Laptop("Lenovo", 10000);

        System.out.println(laptop.toString());


        //2. getClass()
        System.out.println(laptop.getClass().getName());


        // 3. equals()
        Laptop laptop2 = new Laptop("Lenovo", 10000);

        System.out.println(laptop.equals(laptop2));


        // 4. hashcode()
        System.out.println(laptop.hashCode());
        System.out.println(laptop2.hashCode());


        // 5. clone()

        Laptop laptop3;


        laptop3 = (Laptop) laptop.clone();
        System.out.println(laptop.equals(laptop3));

        System.out.println(laptop3);






    }
}