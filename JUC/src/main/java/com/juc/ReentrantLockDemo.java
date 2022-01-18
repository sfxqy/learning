package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sfx
 * @Description: 线程通信  精确唤醒
 */
public class ReentrantLockDemo {



  ReentrantLock lock = new ReentrantLock();

  Condition condition1 = lock.newCondition();
  Condition condition2 = lock.newCondition();
  Condition condition3 = lock.newCondition();

  int num = 1;

  public void threadTest1(){
    lock.lock();
      try {
        while (num!=1){
          condition1.await();
        }
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName()+" \t"+i);
        }
        num=2;
        condition2.signal();
      }catch (Exception e){
        e.printStackTrace();
      }finally {
        lock.unlock();
      }

  }

  public void threadTest2(){
    lock.lock();
      try {
        while (num!=2){
          condition2.await();
        }
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName()+" \t"+i);
        }
        num=3;
        condition3.signal();
      }catch (Exception e){
        e.printStackTrace();
      }finally {
        lock.unlock();
      }

  }

  public void threadTest3(){
    lock.lock();
      try {
        while (num!=3){
          condition3.await();
        }
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName()+" \t"+i);
        }


      }catch (Exception e){
        e.printStackTrace();
      }finally {
        lock.unlock();
      }
  }
}


class a{

  public static void main(String[] args) {
    ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

    new Thread(()->{
      reentrantLockDemo.threadTest1();
    }).start();
    new Thread(()->{
      reentrantLockDemo.threadTest2();
    }).start();
    new Thread(()->{
      reentrantLockDemo.threadTest3();
    }).start();


  }

}
