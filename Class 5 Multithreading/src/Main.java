/*

    Life Cycle of a thread

    Thread scheduler

    1. New
    2. Active
            Runnable -> stay in this state, waiting for thread scheduler to run them [Queue]
            Running -> the thread got the CPU,
    3. Blocked/waiting
    4. Timed waiting -> sleep(10)
    5. Terminated -> When job is done or exception occured

 */

/*
    synchronised public void createInstance() {
        if(instance == null) {
            instance = new Instance();
        }
        return instance;
    }

 */




class Counter {
    int count;
    public Counter() {
        this.count = 0;
    }
    public void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable obj1 = () ->
        {
            for (int i = 0; i < 100; i++) {
                c.increment();
            }
        };

        Runnable obj2 = () ->
        {
            for (int i = 0; i < 100; i++) {
                System.out.println(c.getCount());
            }
        };


        //1. New State
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);


        //2. Active
        t1.start();
        System.out.println(t1.getState());
        t1.join();
        t2.start();

        
        t2.join();

    }
}