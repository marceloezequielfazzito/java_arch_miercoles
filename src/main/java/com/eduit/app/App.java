package com.eduit.app;


import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Long ini = System.currentTimeMillis();

        List<String> data = new ArrayList<>();
        List<MyFuture> futures = new ArrayList<>();
        for (int i = 0 ; i < 240 ; i++){
            Execution execution = new Execution();
            MyFuture future = execution.execute();
            futures.add(future);
        }


        for (MyFuture future : futures){

            List<String> futureReturnData = future.get();

            data.addAll(futureReturnData);
        }


        data.forEach(System.out::println);
        Long end = System.currentTimeMillis();
        System.out.println( "elapsed time seg " + ((end - ini) / 1000)  );



    }
}
