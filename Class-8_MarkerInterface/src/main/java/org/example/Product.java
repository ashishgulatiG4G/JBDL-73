package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Cloneable, Serializable, Comparable<Product> {
    int pid;
    String pbame;
    double cost;

    public Product(int pid, String pbame, double cost) {
        this.pid = pid;
        this.pbame = pbame;
        this.cost = cost;
    }

    void showDetail (){
        System.out.println("Product ID: " + this.pid);
        System.out.println("Product name: " + this.pbame);
        System.out.println("Product cost: " + this.cost);

    }

    public Object clone() {
        return new Product(this.pid, this.pbame, this.cost);
    }

    @Override
    public int compareTo(Product o) {
        return (this.pid == o.pid && Objects.equals(this.pbame, o.pbame) && this.cost == o.cost) ? 1 : -1;
    }
}
