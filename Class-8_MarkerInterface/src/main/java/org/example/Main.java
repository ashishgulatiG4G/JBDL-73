package org.example;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Scanner sc = new Scanner((System.in));
//        System.out.println("Id: " );
//        int pid = sc.nextInt();
//
//        System.out.println("Name: " );
//        String name = sc.next();
//
//        System.out.println("Cost: " );
//        double cost = sc.nextDouble();
//
//        Product p1 = new Product(pid, name, cost);
//        Product p2 = (Product) p1.clone();
//        p2.showDetail();
//        Main.Serialise(p2);
//        DeSerialise(p1);


        ShapeDao shapeDao = new ShapeDao();


        try {
            shapeDao.delete(new Circle());
            shapeDao.delete(new Triangle());
        } catch (Exception e) {
            e.printStackTrace();
        }
//




    }

    public static void Serialise(Product p1) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("product.txt"));
        outputStream.writeObject(p1);
        outputStream.flush();
        outputStream.close();
        System.out.println("Done");
    }

    public static void DeSerialise(Product p1) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("product.txt"));
        Product p2 = (Product) objectInputStream.readObject();

        if(p2.compareTo(p1) > 0) System.out.println("Equal");
        else System.out.println("Unequal");
        objectInputStream.close();





    }

}