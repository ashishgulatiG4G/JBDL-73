package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for(int i = 0; i < 100000; i++) {
//            Runnable worker = ;
            executorService.execute(new WorkerThread("Message: " + i));

        }

        executorService.shutdown();

    }


}
