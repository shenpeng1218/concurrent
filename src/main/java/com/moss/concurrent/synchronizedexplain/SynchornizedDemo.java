package com.moss.concurrent.synchronizedexplain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchornizedDemo {

    public void test1(int j){
        synchronized (this){
            for(int  i = 0; i < 30; i++){
                System.out.println(j + "method test one : =====" + i);
            }
        }
    }

    public synchronized void test2(int j){
        for(int  i = 0; i < 30; i++){
            System.out.println(j + "method test two : =====" + i);
        }
    }

    public static void main(String[] args) {
        SynchornizedDemo demo1 = new SynchornizedDemo();
        SynchornizedDemo demo2 = new SynchornizedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            demo1.test1(1);
        });

        executorService.execute(() -> {
            demo1.test1(2);
            //demo2.test1(2);
        });

    }
}
