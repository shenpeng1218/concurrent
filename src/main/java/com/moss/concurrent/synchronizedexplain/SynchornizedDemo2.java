package com.moss.concurrent.synchronizedexplain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchornizedDemo2 {

    public void test1(int j){
        synchronized (SynchornizedDemo2.class){
            for(int  i = 0; i < 100; i++){
                System.out.println(j + "method test one : =====" + i);
            }
        }
    }

    public synchronized static void test2(int j){
        for(int  i = 0; i < 100; i++){
            System.out.println(j + "method test two : =====" + i);
        }
    }

    public static void main(String[] args) {
        SynchornizedDemo2 demo1 = new SynchornizedDemo2();
        SynchornizedDemo2 demo2 = new SynchornizedDemo2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            demo1.test2(1);
        });

        executorService.execute(() -> {
            demo2.test2(2);
        });

    }
}
