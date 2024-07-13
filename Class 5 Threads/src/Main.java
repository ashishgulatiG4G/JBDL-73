class A extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("In A");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("In B");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

//class Arun implements Runnable {
//
//    @Override
//    public void run() {
//        for(int i = 0; i < 100; i++) {
//            System.out.println("In A");
//        }
//    }
//}
//
//class Brun implements Runnable {
//
//    @Override
//    public void run() {
//        for(int i = 0; i < 100; i++) {
//            System.out.println("In B");
//        }
//    }
//}



public class Main {
    public static void main(String[] args) throws InterruptedException {
//
        A a = new A();
        B b = new B();

        a.start();
        a.join();
        b.start();
        b.join();

        System.out.println(Thread.currentThread());


//        Runnable arun = new Arun();
//        Runnable brun = new Brun();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 100; i++) {
//                    System.out.println("In A");
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 100; i++) {
//                    System.out.println("In A");
//                }
//            }
//        });

//        Thread t1 = new Thread(() -> {
//            for(int i = 0; i < 100; i++) {
//                System.out.println("In A");
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for(int i = 0; i < 100; i++) {
//                System.out.println("In B");
//            }
//        });
//
//        t1.start();
//        t2.start();

    }


    /*
        Threads in JAVA


        [H/w] CPU, RAM
               |
           [OS layer]
               |
             [S/W]


        Multitasking -> When multiple S/W are being run on a machine
            Multicore, Context Switching, Scheduler

        1. Process based multitasking [Multiprocessing]
        2. Thread based multitasking


        Running Program <- process

            Process -> Threads [T1, T2,....]

        Threads -> Subprocess [smallest unit of a process]
                    which are lightweight
                    can run parallely
                    share common pool of resources


           2 ways to create a thread
                1. Extending Thread Class
                2. By implementing runnable interface

     */



}