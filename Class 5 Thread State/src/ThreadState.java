class xyz implements Runnable {
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("(5) The state of thread t1 while it invoked the method join() on thread t2 " + ThreadState.t1.getState());
    }
}


public class ThreadState implements Runnable{

    public static Thread t1;
    public static ThreadState obj;

    public static void main(String[] args) {
        obj = new ThreadState();
        t1 = new Thread(obj);

        // NEW state

        System.out.println("(1) The state of thread t1 after we spin it: " + t1.getState());

        t1.start();

        System.out.println("(2) The state of thread t1 after invoking it: " + t1.getState());

    }

    @Override
    public void run() {
        xyz obj = new xyz();
        Thread t2 = new Thread(obj);

        // NEW state

        System.out.println("(3) The state of thread t2 after we spin it: " + t2.getState());

        t2.start();

        System.out.println("(4) The state of thread t2 after calling start() on it: " + t2.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("(6) The state of thread t2 after performing run(): " + t2.getState());

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("(7) The state of thread t2 when it has completed: " + t1.getState());



    }
}