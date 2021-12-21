package com.juc;

import java.util.concurrent.Semaphore;

/**
 * @author sfx
 * @Description
 */
public class SemaphoreDemo {


  public static void main(String[] args) {

    Semaphore semaphore = new Semaphore(3);

    for (int i=0;i<6;i++){
      final int n=i;
      new Thread(()->{
       try {
         semaphore.acquire();
         System.out.println(Thread.currentThread().getName()+"---开始-----"+n);
         Thread.sleep(2000);
        // System.out.println(Thread.currentThread().getName()+"---结束-----"+n);
       }catch (Exception e){
         e.printStackTrace();
       }finally {
         semaphore.release();
       }
      }).start();
    }

  }

}
