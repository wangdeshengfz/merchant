package com.test.merchant.daily;

import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.FutureTask;  
  
public class CallableThreadTest implements Callable<Integer>  
{  
	public static Integer id=0;
    public static void main(String[] args)  
    {  
        CallableThreadTest ctt = null  ;  
        FutureTask<Integer> ft = null  ;  
        for(int i = 0;i < 10;i++)  
        {  ctt = new CallableThreadTest(); ft = new FutureTask<>(ctt); 
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);  
            new Thread(ft,"有返回值的线程"+i).start(); 
        }  
        try  
        {  	
            System.out.println("子线程的返回值："+ft.get());  
            ctt.test(ft.get());
        } catch (InterruptedException e)  
        {  
            e.printStackTrace();  
        } catch (ExecutionException e)  
        {  
            e.printStackTrace();  
        }  
  
    }  
  
    @Override  
    public Integer call() throws Exception  
    {  	id++;
        System.out.println(Thread.currentThread().getName()+" "+id); 
        return id;  
    }  
  
    public void test(Integer  a){
    	System.out.println("执行方法  "+a);
    }
}  