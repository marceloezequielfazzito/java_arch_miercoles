package com.eduit.app.future;

import com.eduit.app.MyFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future<List<String>>> futures = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for ( int j = 0 ; j < 10 ; j++){
            Future<List<String>> future = threadPool.submit(() -> {
                List<String> data = new ArrayList<>();
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 10; i++) {
                    data.add(name + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return data;
            });

            futures.add(future);
        }


        for (Future<List<String>> f : futures){

            List<String> data = f.get();
            result.addAll(data);
        }


        result.forEach(System.out::println);
        */

        /*

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for ( int j = 0 ; j < 10 ; j++){

            threadPool.execute(()->{

                System.out.println(" start process");
                try {
                    int time = new Random().nextInt(10) * 100;
                    Thread.sleep(time);
                    System.out.println(" end process in " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });
        }

        threadPool.shutdown();

        threadPool.awaitTermination(10,TimeUnit.MILLISECONDS);

      */
      /*
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,new LinkedBlockingQueue<>());


        for ( int j = 0 ; j < 10 ; j++){

            threadPool.execute(()->{

                System.out.println(" start process");
                try {
                    int time = new Random().nextInt(10) * 100;
                    Thread.sleep(time);
                    System.out.println(" end process in " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });
        }

        threadPool.shutdown();

        threadPool.awaitTermination(10,TimeUnit.MILLISECONDS);


       */
    }

}
