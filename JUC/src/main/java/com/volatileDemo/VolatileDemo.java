package com.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sfx
 * @Description
 */
public class VolatileDemo {


  public volatile int number =0 ;

  public AtomicInteger num= new AtomicInteger(0);
  public static void main(String[] args) {
    VolatileDemo volatileDemo = new VolatileDemo();
    volatileDemo.volatileTest();
    System.out.println("--------------");
    volatileDemo.AtomicTest();
  }



  //不保证原子性
  public void volatileTest(){
    for (int i=0;i<100;i++){
      new Thread(()->{
        try {
          for (int j=0;j<200;j++){
            number++;
          }
        }catch (Exception e){
          e.printStackTrace();
        }finally {

        }
        if (number==100*200)
        System.out.println(number);
      }).start();
    }

  }


  public void AtomicTest(){
    for (int i=0;i<100;i++){
      new Thread(()->{
        try {
          for (int j=0;j<200;j++){
            num.incrementAndGet();
          }
        }catch (Exception e){
          e.printStackTrace();
        }finally {

        }
        if (num.get()==100*200)
        System.out.println(num.get());
      }).start();
    }
  }

}
