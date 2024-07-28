package org.example;

class Table {

    public void setN(int n) {
        this.n = n;
    }

    int n;

    void printTable(int n)  {

        synchronized (Table.class) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.out.println("Exc");
                }

            }



        }


    }

}

class Thread1 extends Thread {
    Table t;
    Thread1(Table t) {
        this.t = t;
        t.setN(5);
    }

    public void run() {
        t.printTable(5);
    }

}

class Thread2 extends Thread {
    Table t;
    Thread2(Table t) {
        this.t = t;
        t.setN(10);
    }

    public void run() {
        t.printTable(100);
    }

}

public class TestSync{
    public static void main(String[] args) {
        Table t = new Table();
        Thread1 t1 = new Thread1(t);
        Thread2 thread2 = new Thread2(t);
        t1.start();
        thread2.start();
    }
}

