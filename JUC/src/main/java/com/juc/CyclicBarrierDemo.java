package com.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @author sfx
 * @Description:让一组线程到达一个屏障时备阻塞，直到最后一个线程到达屏障时，屏障解除，所有被屏障拦截的线程继续干活
 */
public class CyclicBarrierDemo {


  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
      System.out.println("前置线程执行完毕");
    });

    for (int i=0;i<7;i++){
      final int temp =i;
      new Thread(()->{
        System.out.println(Thread.currentThread()+"---------"+temp );
        try {
          cyclicBarrier.await();
          System.out.println("开始干活---------"+Thread.currentThread()+"---------"+temp );

        }catch (Exception e){
          e.printStackTrace();
        }finally {

        }
      }).start();
    }
  }

}
