package org.example;

public class ThreadExample extends Thread{
    public void run() {

        for(int i = 0; i < 5; i++) {


            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println("Thread: " + Thread.currentThread() +", "+ i);


        }
    }


}
