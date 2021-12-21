package com.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sfx
 * @Description：手写自旋锁 原理：cas（比较并交换）
 *                            加锁阶段先判断期望值是否为null，为null时通过原子类设置原子类的值为当前线程对象，加锁成功
 *                            解锁截断：直接将原子类的值设置为null
 */
public class Spinlocks {

  public  AtomicReference atomicReference=new AtomicReference(null);

  private int n=0;

  public void lock(){
    Thread thread = Thread.currentThread();
    while (!atomicReference.compareAndSet(null,thread)){

    }
  }


  public void unlock(){
    Thread thread = Thread.currentThread();
    atomicReference.compareAndSet(thread,null);
  }

  public static void main(String[] args) {
    Spinlocks spinlocks = new Spinlocks();
    spinlocks.testNotSpinlocks();
    System.out.println(spinlocks.n);
    System.out.println("-------------------------");
    Spinlocks spinlocks1 = new Spinlocks();
    spinlocks1.testSpinlocks();

  }


  public void testNotSpinlocks(){
    for (int i=0;i<100;i++){
      new Thread(()->{
        n++;
      }).start();
    }
  }


  public void testSpinlocks(){
    Spinlocks spinlocks = new Spinlocks();
    for (int i=0;i<100;i++){
      new Thread(()->{
        try {
          spinlocks.lock();
          spinlocks.n++;
        }catch (Exception e){
          e.printStackTrace();
        }finally {
          spinlocks.unlock();
        }
      if (spinlocks.n==100){
        System.out.println(spinlocks.n);
      }
      }).start();
    }
  }
}
