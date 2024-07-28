package org.example;

public class ThreadDaemon extends Thread{

    public void run() {
        if(Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread");
        } else {
            System.out.println("user thread");
        }
    }

}
