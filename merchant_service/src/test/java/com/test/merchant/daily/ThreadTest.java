package com.test.merchant.daily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
       for(int i=0;i<20;i++){
           pool.execute(new MyThread("线程"+i));
       }
    }

}
