package com.example.raceCondition;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class parallel {
    private int count = 0;

    private int consumer = 40;
    private int round = 10000;

    public  parallel() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(consumer);

        for (int i = 1; i <= consumer; i++){
            Callable<Integer> task = () -> sum(round);
            executorService.submit(task);
        }

        Thread.sleep(30000);
        System.out.println("count:"+count);
    }

    public int sum(int round){
        for (int i = 1; i <= round;i++) {
            int count = this.count;
            count = count + 1;
            this.count = count;
        }
        return 0;
    }

}
