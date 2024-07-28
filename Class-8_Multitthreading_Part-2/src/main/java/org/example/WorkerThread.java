package org.example;

public class WorkerThread implements Runnable{

    String msg;

    public WorkerThread(String message) {
        this.msg = message;
    }

    public void run() {
        System.out.println("[Start: " + Thread.currentThread().getName() + ", Message: " + msg);
        processMessage();
        System.out.println("[End]: " + Thread.currentThread().getName() + ", Message: " + msg);


    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
