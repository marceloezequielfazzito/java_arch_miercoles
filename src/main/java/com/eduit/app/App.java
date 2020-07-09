package com.eduit.app;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {


        Long init = System.currentTimeMillis();

        List<String> data = new ArrayList<>();

       List<MyFuture> futures = new ArrayList<>();

        for ( int i = 0 ; i < 1000 ; i++){
            Execution execution = new Execution();
            MyFuture future = execution.execute();
            futures.add(future);
        }


        for (MyFuture f : futures){
            List<String> returnData = f.get();

            data.addAll(returnData);
        }


        data.forEach(System.out::println);

        System.out.println(data.size());

        Long end = System.currentTimeMillis();

        System.out.println( " elapsed time  : " + ((end - init)/1000)  );

    }

}
