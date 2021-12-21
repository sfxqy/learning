package com.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author sfx
 * @Description
 */
public class CountDownLatchDemo {


  public static void main(String[] args)throws Exception {
    CountDownLatch countDownLatch = new CountDownLatch(7);

    for (int i=0;i<7;i++){
      final int tempInt=i;

       new Thread(() -> {
         System.out.println(Thread.currentThread()+"----------"+tempInt);
         try {
           countDownLatch.countDown();
         }catch (Exception e){
           e.printStackTrace();
         }finally {

         }
       }).start();
    }

    countDownLatch.await();
    System.out.println("执行结束");

  }

}
