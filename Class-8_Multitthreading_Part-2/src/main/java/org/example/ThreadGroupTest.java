package org.example;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("Parent TG");
        Runnable runnable = () -> System.out.println(Thread.currentThread());
        Thread t1 = new Thread(tg1, runnable, "Thread-1");

        Thread t2 = new Thread(tg1, runnable, "Thread-2");

        t1.start(); t2.start();

        ThreadGroup tg2 = new ThreadGroup(tg1, "The child group");
        Thread t3 = new Thread(tg2, runnable, "Thread-3");
        t3.start();


//        try {
//            t1.join(); t2.join(); t3.join();
//        } catch (InterruptedException e) {
//            System.out.println("Error while joining");
//        }

        System.out.println(tg2.getParent());

//        System.out.println(tg1.activeCount());



    }
}
