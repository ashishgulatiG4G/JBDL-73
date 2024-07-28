package org.example;

public class Main {
    public static void main(String[] args) {

//        ThreadExample threadExample1 = new ThreadExample();
//        ThreadExample threadExample2 = new ThreadExample();
//        ThreadExample threadExample3 = new ThreadExample();
//
//
////        What happens when we call run method
////        threadExample1.run();
////        threadExample2.run();
//
//        threadExample1.start();
//        try {
//            threadExample1.join(500);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//
//        threadExample2.start();
//
//        threadExample2.setName("Main-2");
//        threadExample2.setPriority(10);
//

//
//        threadExample3.start();


//        // Daemon threads -> Service provider threads, its life depends if there are others
//            threads to provide service for
        // garbage collector

        ThreadDaemon threadExample1 = new ThreadDaemon();

//
        threadExample1.setDaemon(true);
        threadExample1.start();
        threadExample1.setDaemon(true);
        ThreadDaemon threadExample2 = new ThreadDaemon();
        ThreadDaemon threadExample3 = new ThreadDaemon();

        threadExample2.start();
        threadExample3.start();


//
//        threadExample2.start();
//
//        threadExample2.setName("Main-2");
//        threadExample2.setPriority(10);
//
//        // Daemon threads -> Service provider threads, its life depends if there are others
////            threads to provide service for
//
//        threadExample3.start();



    }
}