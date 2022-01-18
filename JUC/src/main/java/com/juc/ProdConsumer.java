package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sfx
 * @Description:生产者消费者
 * 虚假唤醒：判断线程是否继续等待的地方需要使用循环进行控制，不能用if进行控制
 * 原   因：如果使用的if来进行睡眠await控制的时候，假设线程A执行了一次increment()方法，此时A线程调用signalAll()方法唤醒所有线程
 *         第二次线程执行权又被A获取，但是此时判断资源n为1，这时调用await方法进行睡眠，同时让出线程，b线程获取到执行权执行decrement()，
 *         此时资源n的值减小到0，然后C获取到线程执行权对资源n进行++操作，同时唤醒所有线程，如果此时线程A被唤醒，此时线程A会接着往下执行，
 *         因为A线程在最开始已经执行到if内部，此时被唤醒后会继续向下执行。不会再对资源n进行判断，此时资源n的值就会变成2，造成了资源的虚假唤醒。
 *
 * synchronized和ReentrantLock异同
 *    1.原始构成
 *      synchronized关键字基于jvm层面
 *      底层基于monitorenter
 *      lock是基于api层面
 *
 *    2.使用方法：
 *      synchronized不需要用户手动去释放锁，当synchronized代码执行完成之后系统会自动让线程释放对锁的占用
 *      ReentrantLock则需要用户去手动释放锁，若没有手动释放锁则可能会导致死锁。
 *      需要lock()和Unlock()方法配合try/finally语句块来完成
 *
 *    3.等待是否可以中断
 *       synchronized不可中断，除非是抛出异常或者是正常执行完成
 *       ReentrantLock()可以中断
 *
 *    4.加锁是否公平
 *       synchronize非公平锁
 *       reentrantlock()两者都可以，通过构造方法传入boolean值，true是公平锁，false是非公平锁
 *
 *    5.锁绑定多个条件condition
 *    synchronize没有
 *    reentrantlock用来实现分组唤醒，可以精确唤醒
 *
 */
public class ProdConsumer {

  private int n=0;

  ReentrantLock lock = new ReentrantLock();

  Condition condition = lock.newCondition();

  public void increment(){
    lock.lock();
    try {
      while (n>0){
        condition.await();
      }
      n++;
      System.out.println(Thread.currentThread().getName()+"===="+n);
      condition.signalAll();
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      lock.unlock();
    }
  }


  public void decrement(){
    lock.lock();
    try {
      while (n<=0){
        condition.await();
      }
      n--;
      System.out.println(Thread.currentThread().getName()+"===="+n);
      condition.signalAll();
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      lock.unlock();
    }
  }


  public static void main(String[] args) {
    ProdConsumer prodConsumer = new ProdConsumer();
    new Thread(()->{
      for (int i = 0; i < 3; i++) {
        prodConsumer.increment();
      }
    }).start();
    new Thread(()->{
      for (int i = 0; i < 3; i++) {
        prodConsumer.increment();
      }
    }).start();
    new Thread(()->{
      for (int i = 0; i < 3; i++) {
        prodConsumer.decrement();
      }
    }).start();
    new Thread(()->{
      for (int i = 0; i < 3; i++) {
        prodConsumer.decrement();
      }
    }).start();

  }

}
