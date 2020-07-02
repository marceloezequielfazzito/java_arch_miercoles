package com.eduit.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App2 {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0 ; i < 10 ; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
        //Creates a new ThreadPoolExecutor with the given initial parameters and default thread factory and rejected execution handler.

        /*
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        for (int i = 0 ; i < 10 ; i++) {
            poolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

        poolExecutor.shutdown();
        try {
            poolExecutor.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */


        /*
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);


        scheduledThreadPool.scheduleWithFixedDelay(()-> System.out.println(" waiting ") ,0, 500 , TimeUnit.MILLISECONDS);

        */

        /*
        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        List<Future<List<String>>> futures = new ArrayList<>();
        List<String> result = new ArrayList<>();

        Callable<List<String>> callable = () -> {
            List<String> data = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                String tName = Thread.currentThread().getName();
                data.add(tName + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return data;
        };


        for ( int i = 0 ; i < 6 ; i++) {
            Future<List<String>> future = threadPool.submit(callable);
            futures.add(future);
        }


        for (Future<List<String>> future : futures){

            List<String> futureReturnData = null;
            try {
                futureReturnData = future.get();
                result.addAll(futureReturnData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        result.forEach(System.out::println);
        */


        /*
        Runnable runnable = ()-> {
          String tName = Thread.currentThread().getName();
          for ( int i = 0 ; i < 10 ; i++){
              System.out.println(tName + " " + i);
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };


        for ( int i = 0 ; i < 240 ; i++) {
            threadPool.execute(runnable);
        }
        */






    }
}
