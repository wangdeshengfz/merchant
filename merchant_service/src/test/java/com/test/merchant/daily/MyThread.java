package com.test.merchant.daily;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread{
    private static Logger logger = LoggerFactory.getLogger(MyThread.class);
    private static int n = 0;
    private static String tag = "";
    private String threadName;
    
    MyThread (String threadName){
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        business();
/*        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
    
    private void business(){
        tag += ","+getN();
        logger.info(threadName + ":" + tag);
    }
    
    private int getN(){
        synchronized(this){
            if(n == 0){
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n = 1;
            }else{
                n=2;
            }
        }
        return n;
    }
}
